import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Test {

    @ParameterizedTest
    @CsvSource({
            "testcases/dfa1.txt, testcases/input1.txt, testcases/output1.txt",
    })   
    public void testOnDefaultInput(String dfaSpecFilePath, String inputFilePath, String outputFilePath) throws IOException, URISyntaxException {
        //Loading files
        Path dfaSpecPath = Paths.get(ClassLoader.getSystemResource(dfaSpecFilePath).toURI());
        Path inputPath = Paths.get(ClassLoader.getSystemResource(inputFilePath).toURI());
        Path outputPath = Paths.get(ClassLoader.getSystemResource(outputFilePath).toURI());
        
        //Reading and parsing the DFA specification
        CharStream dfaSpec = CharStreams.fromFileName(dfaSpecPath.toString());
        DFAGrammarLexer lexer = new DFAGrammarLexer(dfaSpec);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DFAGrammarParser parser = new DFAGrammarParser(tokens);
        ParseTree tree = parser.dfa(); // parse; start at prog
        DFABuilder builder = new DFABuilder();
        DFA dfa = builder.visit(tree);
        
        // Getting output from the DFA given the input taken from the input file
        List<String> strings = Files.readAllLines(inputPath);
        Boolean[] result = new Boolean[strings.size()];
        int index = 0;
        for (String string : strings) {
            result[index++] = dfa.accept(string);
        }

        //Reading expected output and comparing
        String expecteOuput = Files.readString(Paths.get(outputPath.toString()));

        assertEquals(Arrays.toString(result), expecteOuput);
    }
}