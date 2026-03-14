import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class App {
    public static void main(String[] args) throws Exception {

        String[] ars = new String[]{System.getProperty("user.dir") + "/RE/regular-expression-project-template/src/test/resources/testcases/re-member2.txt", System.getProperty("user.dir") + "/RE/regular-expression-project-template/src/test/resources/testcases/re-member2-input.txt"};
        String REFile = ars[0];
        CharStream RESpec = CharStreams.fromFileName(REFile);

        REGrammarLexer lexer = new REGrammarLexer(RESpec);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        REGrammarParser parser = new REGrammarParser(tokens);
        parser.removeErrorListeners();
        SimpleErrorListener listener = new SimpleErrorListener();
        parser.addErrorListener(listener);

        ParseTree tree = parser.expr(); // parse; start at expr

        if (!listener.isOk()) {
            System.out.println("There are compilation errors, fix them!");
            return;
        }

        REBuilder built = new REBuilder();
        RegularExpression re = built.visit(tree);

        String inputFile = ars[1];
        Path input = Paths.get(inputFile);
        List<String> strings = Files.readAllLines(input);

        Boolean[] result = new Boolean[strings.size()];

        int index = 0;

        for (String string : strings) {
            result[index++] = re.accept(string);
        }
        System.out.println(Arrays.toString(result));
    }

}
