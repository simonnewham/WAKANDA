import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestLexer {

    private static List<String> tokens = new ArrayList<String>();

    public static List<String> getTokens() {
        return tokens;
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("No file arguments given");
        } else {
            // parse each file argument given
            for (String arg : args) {
                FileReader file;
                // attempt to open file
                try {
                    file = new FileReader(arg);
                } catch (FileNotFoundException e) {
                    System.err.println(arg + " was not found!");
                    continue; // try next file
                }
                // create lexer
                Lexer lexer = new Lexer(file);
                // start tokenizing file
                System.out.println("Tokenizing " + arg + "...");

                int numTokens = 0;
                Token token;
                do {
                    token = lexer.getToken();
                    numTokens++;

                    if (token.getType() == TokenType.UNKNOWN) {
                        // print token type and location
                        System.err.print(token.getType());

//                        tokens.add(token.getType().toString());
                        System.out.println();
                        continue;
                    }

                    System.out.print(token.getType() + " : " + lexer.returnSymbol(token)); //Prints out punctuations and operators

                    tokens.add(token.getType() + " : " + lexer.returnSymbol(token));

                    if (null == token.getType()) {
                        System.out.println();
//                        tokens.add("\n");
                    } else { // print out semantic values for IDENTIFIER and INT_CONST tokens
                        String temp = "";

                        switch (token.getType()) {
                            case IDENTIFIER:
                                System.out.println("" + token.getAttribute().getIdVal());

                                temp = tokens.get(tokens.size() - 1);
                                tokens.remove(tokens.size() - 1);

                                tokens.add(temp + token.getAttribute().getIdVal());

                                break;
                            case INT_CONST:
                                System.out.println("" + token.getAttribute().getIntVal());

                                temp = tokens.get(tokens.size() - 1);
                                tokens.remove(tokens.size() - 1);

                                tokens.add(temp + token.getAttribute().getIntVal());

                                break;
                            case FLOAT_CONST:
                                System.out.println("" + token.getAttribute().getFloatVal());

                                temp = tokens.get(tokens.size() - 1);
                                tokens.remove(tokens.size() - 1);

                                tokens.add(temp + token.getAttribute().getFloatVal());

                                break;

                            case STRING:
                                System.out.println("" + token.getAttribute().getIdVal());

                                temp = tokens.get(tokens.size() - 1);
                                tokens.remove(tokens.size() - 1);

                                tokens.add(temp + token.getAttribute().getIdVal());

                                break;
                            default:
                                System.out.println();
//                                tokens.add("\n");
                                break;
                        }
                    }

                } while (token.getType() != TokenType.EOF);

                System.out.println("---");
                System.out.println("Number of tokens: " + numTokens);
                System.out.println("\n");

                //at this point, tokens is an Arraylist<String> with elemets of
                //of the form "type : value"

                //print the tokens to a file
                System.out.println("Writing to file");
                BufferedWriter outFile = new BufferedWriter(new FileWriter(new File("lexerOutput.txt")));
                for (String s : tokens) {
//                    System.out.println(s);
                    outFile.write(s + "\n");
                }
                outFile.close();
                System.out.println("Complete");

            }
        }
    }
}
