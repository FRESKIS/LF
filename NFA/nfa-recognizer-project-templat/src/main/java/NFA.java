import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class NFA {

    String[] states;
    List<trans> transitions = new ArrayList<>();
    String inicial;
    List<String> finals = new ArrayList<>();
    
    public NFA(String[] states) {
        this.states = states;
    }

    public void setInitialState(String state) {
        this.inicial = state;
    }

    public String getInitialState() {
        // your code goes here
        return this.inicial;
    }

    public void addFinalState(String state) {
        this.finals.add(state);
    }

    // Method to add a transition to the table
    public void addTransition(String state, Character input, String nextState) {
        this.transitions.add(new trans(state, Label.createNonEmptyLabel(input), nextState));
    }

    public void addEpsilonTransition(String state, String nextState) {
        this.transitions.add(new trans(state, Label.createEmptyLabel(), nextState));
    }

    // Outputs true if the NFA accept the input string
    //The strategy we follow is to convert the NFA into a DFA
    public boolean accept(String input) {
        DFA dfa = NFAtoDFA();
        return dfa.accept(input);
    }

    public DFA NFAtoDFA(){
        Set<Label> labels = this.getAllLabels();
        String new_inicial = this.inicial;
        List<String> new_finals = new ArrayList<>();
        String[] new_states = powerSet(this.states);
        List<trans> new_transitions = new ArrayList<>();

        // We get the initial state and all the states reachable from it through empty transitions
        for (trans elem : this.transitions.stream().filter((x) -> x.state.equals(this.inicial) && x.input.isEmptyTransition()).toList()) {
            new_inicial = new_inicial + " " + elem.nextState;
        }

        //we get the transitions for the new states
        //for each new state
        for (String st : new_states) {
            //and each possible path through each of the labels
            for (Label label : labels) {
                Set<String> new_nextState = new TreeSet<>();
                //we get all separated states in the new state
                for (String state : st.split(" ")) {
                    //and for each of them we get the states reachable through the label
                    for (trans tr : this.transitions.stream().filter((x) -> x.state.equals(state) && x.input.equals(label)).toList()) {
                        new_nextState.add(tr.nextState);
                        //and we also get the states reachable from those through empty transitions
                        checkEpsilonTransitions(this.transitions, new_nextState, tr.nextState);
                    }
                }
                new_transitions.add(new trans(st, label, String.join(" ", new_nextState)));
            }
        }

        //Now we filter all states that aren't accesible throught the main state
        checkUnusedStates(new_transitions, new_states, new_inicial);

        for (String st : new_states) {
            if (Arrays.stream(st.split(" ")).anyMatch(x -> this.finals.contains(x))) {
                new_finals.add(st);
            }
        }


        DFA dfa = new DFA(new_states);
        dfa.setInitialState(new_inicial);
        for (String st : new_finals) {
            dfa.addFinalState(st);
        }
        for (trans tr : new_transitions) {
            dfa.addTransition(tr.state, tr.input.getValue(), tr.nextState);
        }

        return dfa;
    }

    public Set<Label> getAllLabels(){
        // your code goes here
        return this.transitions.stream().filter((x) -> !x.input.isEmptyTransition()).map((x) -> x.input).collect(Collectors.toSet());
    }

    public class trans {
        public String state;
        public Label input;
        public String nextState;

        public trans(String state, Label input, String nextState) {
            this.state = state;
            this.input = input;
            this.nextState = nextState;
        }
    }

    public static String[] powerSet(String[] states) {

        int n = states.length;
        String[] result = new String[1 << n];
        int index = 0;

        for (int i = 0; i < (1 << n); i++) {

            String subset = "";
            boolean first = true;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    if (!first) subset += " ";
                    subset += states[j];
                    first = false;
                }
            }

            result[index++] = subset;
        }

        return result;
    }

    private void checkEpsilonTransitions(List<trans> transition, Set<String> visited, String Studied_state) {
        for (trans eps : transition.stream().filter((x) -> x.state.equals(Studied_state) && x.input.isEmptyTransition()).toList()) {
            visited.add(eps.nextState);
            checkEpsilonTransitions(transition, visited, eps.nextState);
        }
    }

    private void checkUnusedStates(List<trans> transition, String[] states, String inicial_state) {
        for (String st : states){
            if ( st.equals(inicial_state)) continue;
            if ( !transition.stream().anyMatch((x) -> x.nextState.equals(st) && !x.state.equals(st)) ) {
                transitions.removeIf((x) -> x.state.equals(st));
                states = Arrays.stream(states).filter(x -> !x.equals(st)).toArray(String[]::new);
                checkUnusedStates(transition, states, inicial_state);
                break;
            }
        }
    }
                    
       
}
