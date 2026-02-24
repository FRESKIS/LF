
import java.util.ArrayList;
import java.util.List;


/*A class that models DFAs. States are just strings while labels
 * are characters. 
 * We shall specify DFAs without the requirement that the transition 
 * function is total. In other words, we will let the programmer specify 
 * DFAs with transitions, then assume those transitions all go to a trap state. 
 */
public class DFA {

    String[] states;
    List<trans> transitions = new ArrayList<>();
    String inicial;
    List<String> finals = new ArrayList<>();
    
    /*A constructor that builds a DFA with the set of state names 
     * given as arguments. 
     */
    public DFA(String[] states) {
        this.states = states;
    }

    /*Establish the initial state  */
    public void setInitialState(String state) {
        for (String st : this.states) {
            if (st.equals(state)) {
                this.inicial = st;
                return;
            }
        }
        throw new Error("El estado Inicial no existe dentro del DFA");
    }

    /*Mark a state in the DFA as final*/
    public void addFinalState(String state) {
        for (String st : this.states) {
            if (st.equals(state)) {
                this.finals.add(state);
                return;
            }
        }
        throw new Error("El estado Final no existe dentro del DFA");
    }

    // Method that adds a transition. 
    public void addTransition(String state, Character input, String nextState) {
        this.transitions.add(new trans(state, input, nextState));
    }

    /*Given an input string, this method outputs true if the DFA accepts it.
     * Otherwise it outputs false. 
     */
    public boolean accept(String input) {
        if (input == null || input.isEmpty()) {
            return this.finals.contains(this.inicial);
        }
        String currentState = this.inicial;
        for (char c : input.toCharArray()) {
            boolean foundTransition = false;
            for (trans t : this.transitions) {
                if (t.input == c && t.state.equals(currentState)) {
                    currentState = t.nextState;
                    foundTransition = true;
                    break;
                }
            }
            if (!foundTransition) {
                return false;
            }
        }
        return this.finals.contains(currentState);
    }

    public class trans {
        public String state;
        public char input;
        public String nextState;

        public trans(String state, char input, String nextState) {
            this.state = state;
            this.input = input;
            this.nextState = nextState;
        }
    }

}
