import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
            new_inicial = new_inicial + ", " + elem.nextState;
        }
        new_inicial = "{" + new_inicial + "}";


        return null;
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

            String subset = "{";
            boolean first = true;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    if (!first) subset += ", ";
                    subset += states[j];
                    first = false;
                }
            }

            subset += "}";
            result[index++] = subset;
        }

        return result;
    }
                    
       
}
