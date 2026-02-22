
/*A class that models DFAs. States are just strings while labels
 * are characters. 
 * We shall specify DFAs without the requirement that the transition 
 * function is total. In other words, we will let the programmer specify 
 * DFAs with transitions, then assume those transitions all go to a trap state. 
 */
public class DFA {
    
    /*A constructor that builds a DFA with the set of state names 
     * given as arguments. 
     */
    public DFA(String[] states) {
        //Your code goes here
    }

    /*Establish the initial state  */
    public void setInitialState(String state) {
        // Your code goes here
    }

    /*Mark a state in the DFA as final*/
    public void addFinalState(String state) {
        // Your code goes here
    }

    // Method that adds a transition. 
    public void addTransition(String state, Character input, String nextState) {
        // Your code goes here
    }

    /*Given an input string, this method outputs true if the DFA accepts it.
     * Otherwise it outputs false. 
     */
    public boolean accept(String input) {
        // Your code goes here
        return false;
    }

}
