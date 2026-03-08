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

    public DFA NFAtoDFA() {
        Set<Label> labels = this.getAllLabels();
        Set<String> startSet = new TreeSet<>();
        startSet.add(this.inicial);
        checkEpsilonTransitions(this.transitions, startSet, this.inicial);
        String new_inicial = String.join(" ", startSet);
        String[] new_states = powerSet(this.states);
        List<trans> new_transitions = new ArrayList<>();

        for (String st : new_states) {
            for (Label label : labels) {
                Set<String> nextStatesSet = new TreeSet<>();
                
                if (!st.isEmpty()) {
                    for (String individualState : st.split(" ")) {
                        for (trans tr : this.transitions) {
                            if (tr.state.equals(individualState) && tr.input.equals(label)) {
                                nextStatesSet.add(tr.nextState);
                                checkEpsilonTransitions(this.transitions, nextStatesSet, tr.nextState);
                            }
                        }
                    }
                }
                String nextStateName = String.join(" ", nextStatesSet);
                new_transitions.add(new trans(st, label, nextStateName));
            }
        }

        List<String> new_finals = new ArrayList<>();
        for (String st : new_states) {
            if (!st.isEmpty() && Arrays.stream(st.split(" ")).anyMatch(x -> this.finals.contains(x))) {
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

    /* Recursive function to check if the state given has any epsilon transition
       and if it does, check those states until no more epsilon transitions can be found*/
    private void checkEpsilonTransitions(List<trans> transition, Set<String> visited, String Studied_state) {
        for (trans eps : transition.stream().filter((x) -> x.state.equals(Studied_state) && x.input.isEmptyTransition()).toList()) {
            visited.add(eps.nextState);
            checkEpsilonTransitions(transition, visited, eps.nextState);
        }
    }

    /* Recursive function to check for the states that are unreaachable deleting them */
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
