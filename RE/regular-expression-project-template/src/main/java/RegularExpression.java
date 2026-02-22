/*For simplicity, this  class does not allow for the construction of a regular expression
* that accepts the empty sequence. The reason being that we have no symbol to 
* denote the empty sequence.  
*/
public class RegularExpression {

    public RegularExpression(NFA engine, String re) {
        // your code goes here
    }

    /*An empty regular expression*/
    public RegularExpression() {
        // your code goes here
    }

    /* A regular expression consisting of a single character*/
    public RegularExpression(char a) {
        // your code goes here
    }

    public RegularExpression(char[] chard) {
        // your code goes here
    }

    public RegularExpression(char ini, char end) {
        // your code goes here
    }

    public static RegularExpression createUnionRE(RegularExpression left, RegularExpression right) {
        // your code goes here
        return null;
    }

    public static RegularExpression createSequentialRE(RegularExpression[] res) {
        // your code goes here
        return null;
    }

    public static RegularExpression createStartRE(RegularExpression re) {
        // your code goes here
        return null;
    }


    public static RegularExpression createUnionRE(RegularExpression[] disj) {
        // your code goes here
        return null;
    }

    public Boolean accept(String string) {
        //your code goes here
        return null;
    }

}
