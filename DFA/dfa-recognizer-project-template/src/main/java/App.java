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
        String dfaFile = args[0];
        CharStream dfaSpec = CharStreams.fromFileName(dfaFile);

        DFAGrammarLexer lexer = new DFAGrammarLexer(dfaSpec);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DFAGrammarParser parser = new DFAGrammarParser(tokens);
        parser.removeErrorListeners();
        SimpleErrorListener listener = new SimpleErrorListener();
        parser.addErrorListener(listener);

        ParseTree tree = parser.dfa(); // parse; start at dfa

        if (!listener.isOk()) {
            System.out.println("There are compilation errors, fix them!");
            return;
        }

        DFABuilder built = new DFABuilder();
        DFA dfa = built.visit(tree);

        String inputFile = args[1];
        Path input = Paths.get(inputFile);
        List<String> strings = Files.readAllLines(input);

        Boolean[] result = new Boolean[strings.size()];

        int index = 0;

        for (String string : strings) {
            result[index++] = dfa.accept(string);
        }
        System.out.println(Arrays.toString(result));
    }

}
