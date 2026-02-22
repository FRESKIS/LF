import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) 
            throw new IllegalArgumentException("Was expecting two arguments (files)");
        String NFAFile = args[0];
        CharStream NFASpec = CharStreams.fromFileName(NFAFile);

        NFAGrammarLexer lexer = new NFAGrammarLexer(NFASpec);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        NFAGrammarParser parser = new NFAGrammarParser(tokens);
        parser.removeErrorListeners();
        SimpleErrorListener listener = new SimpleErrorListener();
        parser.addErrorListener(listener);

        ParseTree tree = parser.nfa(); // parse; start at NFA

        if (!listener.isOk()) {
            System.out.println("There are compilation errors, fix them!");
            return;
        }

        NFABuilder built = new NFABuilder();
        NFA nfa = built.visit(tree);

        String inputFile = args[1];
        Path input = Paths.get(inputFile);
        List<String> strings = Files.readAllLines(input);

        Boolean[] result = new Boolean[strings.size()];

        int index = 0;

        for (String string : strings) {
            result[index++] = nfa.accept(string);
        }
        System.out.println(Arrays.toString(result));
    }

}
