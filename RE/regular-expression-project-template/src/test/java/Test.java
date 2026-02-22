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
            "testcases/re1.txt, testcases/input1.txt, testcases/output1.txt",
            "testcases/re2.txt, testcases/input2.txt, testcases/output2.txt",
            "testcases/re-member1.txt, testcases/re-member1-input.txt, testcases/re-member1-output.txt",
            "testcases/re-member2.txt, testcases/re-member2-input.txt, testcases/re-member2-output.txt",
            "testcases/re-member3.txt, testcases/re-member3-input.txt, testcases/re-member3-output.txt",
            "testcases/re-member4.txt, testcases/re-member4-input.txt, testcases/re-member4-output.txt",
    })   
    public void testOnDefaultInput(String regexSpecFilePath, String inputFilePath, String outputFilePath) throws IOException, URISyntaxException {
        //Loading files
        Path regexSpecPath = Paths.get(ClassLoader.getSystemResource(regexSpecFilePath).toURI());
        Path inputPath = Paths.get(ClassLoader.getSystemResource(inputFilePath).toURI());
        Path outputPath = Paths.get(ClassLoader.getSystemResource(outputFilePath).toURI());
        
        //Reading and parsing the regex specification
        CharStream regexSpec = CharStreams.fromFileName(regexSpecPath.toString());
        REGrammarLexer lexer = new REGrammarLexer(regexSpec);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        REGrammarParser parser = new REGrammarParser(tokens);
        ParseTree tree = parser.expr(); // parse; start at prog
        REBuilder builder = new REBuilder();
        RegularExpression re = builder.visit(tree);
        
        // Getting output from the regex given the input taken from the input file
        List<String> strings = Files.readAllLines(inputPath);
        Boolean[] result = new Boolean[strings.size()];
        int index = 0;
        for (String string : strings) {
            result[index++] = re.accept(string);
        }

        //Reading expected output and comparing
        String expecteOuput = Files.readString(Paths.get(outputPath.toString()));

        assertEquals(Arrays.toString(result), expecteOuput);
    }
}