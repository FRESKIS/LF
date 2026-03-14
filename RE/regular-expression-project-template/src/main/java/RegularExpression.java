/*For simplicity, this  class does not allow for the construction of a regular expression
* that accepts the empty sequence. The reason being that we have no symbol to 
* denote the empty sequence.  
*/
public class RegularExpression {

    private static int freshId = 0;

    private final NFA engine;
    private final String re;

    public RegularExpression(NFA engine, String re) {
        this.engine = engine;
        this.re = re;
    }

    /*An empty regular expression*/
    public RegularExpression() {
        String start = freshState();
        String end = freshState();
        NFA automaton = new NFA(new String[]{start, end});
        automaton.setInitialState(start);
        this.engine = automaton;
        this.re = "{}";
    }

    /* A regular expression consisting of a single character*/
    public RegularExpression(char a) {
        String start = freshState();
        String end = freshState();
        NFA automaton = new NFA(new String[]{start, end});
        automaton.setInitialState(start);
        automaton.addFinalState(end);
        automaton.addTransition(start, a, end);
        this.engine = automaton;
        this.re = Character.toString(a);
    }

    public RegularExpression(char[] chard) {
        RegularExpression union = buildUnionFromChars(chard);
        this.engine = union.engine;
        this.re = union.re;
    }

    public RegularExpression(char ini, char end) {
        if (ini > end) {
            throw new IllegalArgumentException("Invalid range: " + ini + "-" + end);
        }
        char[] chars = new char[end - ini + 1];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (ini + i);
        }
        RegularExpression range = buildUnionFromChars(chars);
        this.engine = range.engine;
        this.re = "[" + ini + "-" + end + "]";
    }

    public static RegularExpression createUnionRE(RegularExpression left, RegularExpression right) {
        String start = freshState();
        String end = freshState();

        NFACopy leftCopy = copyOf(left.engine);
        NFACopy rightCopy = copyOf(right.engine);

        String[] states = concat(new String[]{start, end}, leftCopy.states, rightCopy.states);
        NFA automaton = new NFA(states);
        automaton.setInitialState(start);
        automaton.addFinalState(end);

        installCopy(automaton, leftCopy);
        installCopy(automaton, rightCopy);

        automaton.addEpsilonTransition(start, leftCopy.initialState);
        automaton.addEpsilonTransition(start, rightCopy.initialState);

        for (String finalState : leftCopy.finalStates) {
            automaton.addEpsilonTransition(finalState, end);
        }
        for (String finalState : rightCopy.finalStates) {
            automaton.addEpsilonTransition(finalState, end);
        }

        return new RegularExpression(automaton, "(" + left.re + "|" + right.re + ")");
    }

    public static RegularExpression createSequentialRE(RegularExpression[] res) {
        if (res == null || res.length == 0) {
            return new RegularExpression();
        }

        RegularExpression result = res[0];
        for (int i = 1; i < res.length; i++) {
            result = concatenate(result, res[i]);
        }
        return result;
    }

    public static RegularExpression createStartRE(RegularExpression re) {
        String start = freshState();
        String end = freshState();
        NFACopy copy = copyOf(re.engine);

        String[] states = concat(new String[]{start, end}, copy.states);
        NFA automaton = new NFA(states);
        automaton.setInitialState(start);
        automaton.addFinalState(end);

        installCopy(automaton, copy);

        automaton.addEpsilonTransition(start, copy.initialState);
        automaton.addEpsilonTransition(start, end);
        for (String finalState : copy.finalStates) {
            automaton.addEpsilonTransition(finalState, copy.initialState);
            automaton.addEpsilonTransition(finalState, end);
        }

        return new RegularExpression(automaton, "(" + re.re + ")*");
    }


    public static RegularExpression createUnionRE(RegularExpression[] disj) {
        if (disj == null || disj.length == 0) {
            return new RegularExpression();
        }

        RegularExpression result = disj[0];
        for (int i = 1; i < disj.length; i++) {
            result = createUnionRE(result, disj[i]);
        }
        return result;
    }

    public Boolean accept(String string) {
        if (string.isEmpty()) {
            return false;
        }
        return engine.accept(string);
    }

    private static RegularExpression concatenate(RegularExpression left, RegularExpression right) {
        NFACopy leftCopy = copyOf(left.engine);
        NFACopy rightCopy = copyOf(right.engine);

        String[] states = concat(leftCopy.states, rightCopy.states);
        NFA automaton = new NFA(states);
        automaton.setInitialState(leftCopy.initialState);

        installCopy(automaton, leftCopy);
        installCopy(automaton, rightCopy);

        for (String finalState : leftCopy.finalStates) {
            automaton.addEpsilonTransition(finalState, rightCopy.initialState);
        }
        for (String finalState : rightCopy.finalStates) {
            automaton.addFinalState(finalState);
        }

        return new RegularExpression(automaton, left.re + right.re);
    }

    private static RegularExpression buildUnionFromChars(char[] chars) {
        if (chars == null || chars.length == 0) {
            return new RegularExpression();
        }

        RegularExpression[] expressions = new RegularExpression[chars.length];
        for (int i = 0; i < chars.length; i++) {
            expressions[i] = new RegularExpression(chars[i]);
        }
        return createUnionRE(expressions);
    }

    private static NFACopy copyOf(NFA source) {
        java.util.Map<String, String> renaming = new java.util.HashMap<>();
        java.util.Set<String> originalStates = source.getStates();
        String[] states = new String[originalStates.size()];
        int index = 0;
        for (String state : originalStates) {
            String renamed = freshState();
            renaming.put(state, renamed);
            states[index++] = renamed;
        }

        NFACopy copy = new NFACopy();
        copy.states = states;
        copy.initialState = renaming.get(source.getInitialState());
        copy.finalStates = new java.util.HashSet<>();
        copy.transitions = new java.util.ArrayList<>();
        copy.epsilonTransitions = new java.util.ArrayList<>();

        for (String finalState : source.getFinalStates()) {
            copy.finalStates.add(renaming.get(finalState));
        }

        for (java.util.Map.Entry<String, java.util.Map<Label, java.util.Set<String>>> entry : source.getTransitions().entrySet()) {
            String from = renaming.get(entry.getKey());
            for (java.util.Map.Entry<Label, java.util.Set<String>> transition : entry.getValue().entrySet()) {
                for (String target : transition.getValue()) {
                    copy.transitions.add(new Transition(from, transition.getKey().getValue(), renaming.get(target)));
                }
            }
        }

        for (java.util.Map.Entry<String, java.util.Set<String>> entry : source.getEpsilonTransitions().entrySet()) {
            String from = renaming.get(entry.getKey());
            for (String target : entry.getValue()) {
                copy.epsilonTransitions.add(new Transition(from, null, renaming.get(target)));
            }
        }

        return copy;
    }

    private static void installCopy(NFA target, NFACopy copy) {
        for (Transition transition : copy.transitions) {
            target.addTransition(transition.from, transition.symbol, transition.to);
        }
        for (Transition transition : copy.epsilonTransitions) {
            target.addEpsilonTransition(transition.from, transition.to);
        }
    }

    private static String[] concat(String[]... arrays) {
        int total = 0;
        for (String[] array : arrays) {
            total += array.length;
        }

        String[] result = new String[total];
        int index = 0;
        for (String[] array : arrays) {
            for (String value : array) {
                result[index++] = value;
            }
        }
        return result;
    }

    private static String freshState() {
        return "q" + freshId++;
    }

    private static class Transition {
        private final String from;
        private final Character symbol;
        private final String to;

        private Transition(String from, Character symbol, String to) {
            this.from = from;
            this.symbol = symbol;
            this.to = to;
        }
    }

    private static class NFACopy {
        private String[] states;
        private String initialState;
        private java.util.Set<String> finalStates;
        private java.util.List<Transition> transitions;
        private java.util.List<Transition> epsilonTransitions;
    }

}
