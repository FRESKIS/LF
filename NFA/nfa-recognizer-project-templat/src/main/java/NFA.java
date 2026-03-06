import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        // your code goes here
        return null;
     }

    public Set<Label> getAllLabels(){
        // your code goes here
        return null;
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
                    
       
}
