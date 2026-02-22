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
            "testcases/nfa1.txt, testcases/input1.txt, testcases/output1.txt",
            "testcases/nfa-member1.txt, testcases/nfa-member1-input.txt, testcases/nfa-member1-output.txt",
            "testcases/nfa-member2.txt, testcases/nfa-member2-input.txt, testcases/nfa-member2-output.txt",
            "testcases/nfa-member3.txt, testcases/nfa-member3-input.txt, testcases/nfa-member3-output.txt",
            "testcases/nfa-member4.txt, testcases/nfa-member4-input.txt, testcases/nfa-member4-output.txt",
    })   
    public void testOnDefaultInput(String nfaSpecFilePath, String inputFilePath, String outputFilePath) throws IOException, URISyntaxException {
        //Loading files
        Path nfaSpecPath = Paths.get(ClassLoader.getSystemResource(nfaSpecFilePath).toURI());
        Path inputPath = Paths.get(ClassLoader.getSystemResource(inputFilePath).toURI());
        Path outputPath = Paths.get(ClassLoader.getSystemResource(outputFilePath).toURI());
        
        //Reading and parsing the NFA specification
        CharStream nfaSpec = CharStreams.fromFileName(nfaSpecPath.toString());
        NFAGrammarLexer lexer = new NFAGrammarLexer(nfaSpec);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        NFAGrammarParser parser = new NFAGrammarParser(tokens);
        ParseTree tree = parser.nfa(); // parse; start at prog
        NFABuilder builder = new NFABuilder();
        NFA nfa = builder.visit(tree);
        
        // Getting output from the NFA given the input taken from the input file
        List<String> strings = Files.readAllLines(inputPath);
        Boolean[] result = new Boolean[strings.size()];
        int index = 0;
        for (String string : strings) {
            result[index++] = nfa.accept(string);
        }

        //Reading expected output and comparing
        String expecteOuput = Files.readString(Paths.get(outputPath.toString()));

        assertEquals(Arrays.toString(result), expecteOuput);
    }
}