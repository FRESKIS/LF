import java.util.*;

public class NFA {
    
    public NFA(String[] states) {
        //your code goes here
    }

    public void setInitialState(String state) {
        // your code goes here
    }

    public String getInitialState() {
        // your code goes here
        return null;
    }

    public void addFinalState(String state) {
        // your code goes here
    }

    // Method to add a transition to the table
    public void addTransition(String state, Character input, String nextState) {
        // your code goes here
    }

    public void addEpsilonTransition(String state, String nextState) {
        // your code goes here
    }

    // Outputs true if the NFA accept the input string
    //The strategy we follow is to convert the NFA into a DFA
    public boolean accept(String input) {
        // your code goes here
        return false;
    }

    public DFA NFAtoDFA(){
        // your code goes here
        return null;
     }

    public Set<Label> getAllLabels(){
        // your code goes here
        return null;
    }
                    
       
}
