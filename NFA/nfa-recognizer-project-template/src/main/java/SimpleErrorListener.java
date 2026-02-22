import org.antlr.v4.runtime.*;
import java.util.Collections;
import java.util.List;

public class SimpleErrorListener extends BaseErrorListener {
    private boolean ok = true;

    public boolean isOk() {
        return ok;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e) {
        List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
        Collections.reverse(stack);
        System.out.println("rule stack: " + stack);
        System.out.println("line " + line + ":" + charPositionInLine + " at " +
                offendingSymbol + ": " + msg);
        ok = false;
    }
}
