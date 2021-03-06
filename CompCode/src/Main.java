import java.io.IOException;
import java.util.List;

/**
 *
 * @author Ross
 */
public class Main {
    /**
     * Run this main method to run the lexer + parser together
     * @param args array with the the name of the input file
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("starting compiler");
       
        //create Lexer and perform lexical analysis
        TestLexer.main(args);

        List<String> tokens = TestLexer.getTokens();
        //at this point, tokens is an Arraylist<String> with elemets of
        //of the form "type : value"

        //parse tokens
        Parser parser = new Parser();
        parser.setTokens(tokens); //pass tokens arrayList to parser

        parser.parse();



        System.out.println("Compilation complete");
    }
}
