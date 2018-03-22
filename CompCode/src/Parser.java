import java.util.ArrayList;
import java.util.List;

/**
 * Performs the parsing of the token stream
 *
 * @author Ross
 */
public class Parser {

    //the token stream
    private ArrayList<Token> tokens = new ArrayList<Token>();

    //receives the list of tokens as string in the form "type : value"
    //and converts it into a List<Token>
    public void setTokens(List<String> stringTokens) {

        for (String st : stringTokens) {
            String[] temp = st.split(" : ");

            //temp[0] is type, temp[1] is value
            TokenType type = stringToTokenType(temp[0]);

            /*System.out.println("temp0" + temp[0]);

            if (temp.length > 1) {
                System.out.println("temp1" + temp[1]);
            }*/

            //if variable or literal, set token attribute
            TokenAttribute att = null;
            switch (type) {
                case INT_CONST:
                    att = new TokenAttribute(Integer.parseInt(temp[1]));
                    break;
                case FLOAT_CONST:
                    att = new TokenAttribute(Float.parseFloat(temp[1]));
                    break;
                case STRING:
                    att = new TokenAttribute(temp[1]);
                    break;
                case IDENTIFIER:
                    att = new TokenAttribute(temp[1]);
                    break;
                default:
                    break;
            }

            Token t = new Token(type, att);

            tokens.add(t);
        }

        System.out.println("token stream read into parser successfully.");
    }

    //returns the appropriate TokenType given a String
    public static TokenType stringToTokenType(String s) {
        switch (s) {
            case "EXECUTE": {
                return TokenType.EXECUTE;
            }
            case "L_ROUND": {
                return TokenType.L_ROUND;
            }
            case "R_ROUND": {
                return TokenType.R_ROUND;
            }
            case "L_CURLY": {
                return TokenType.L_CURLY;
            }
            case "R_CURLY": {
                return TokenType.R_CURLY;
            }
            case "INT_CONST": {
                return TokenType.INT_CONST;
            }
            case "FLOAT_CONST": {
                return TokenType.FLOAT_CONST;
            }
            case "STRING": {
                return TokenType.STRING;
            }
            case "EQUALS": {
                return TokenType.EQUALS;
            }
            case "PLUS": {
                return TokenType.PLUS;
            }
            case "MINUS": {
                return TokenType.MINUS;
            }
            case "MULTIPLY": {
                return TokenType.MULTIPLY;
            }
            case "DIVIDE": {
                return TokenType.DIVIDE;
            }
            case "LT_EQ": {
                return TokenType.LT_EQ;
            }
            case "GT_EQ": {
                return TokenType.GT_EQ;
            }
            case "IDENTIFIER": {
                return TokenType.IDENTIFIER;
            }
            case "ASSIGN": {
                return TokenType.ASSIGN;
            }
            case "IF": {
                return TokenType.IF;
            }
            case "OTHERWISE": {
                return TokenType.OTHERWISE;
            }
            case "PRINT": {
                return TokenType.PRINT;
            }
            case "NUMS": {
                return TokenType.NUMS;
            } case "FLOAT": {
                return TokenType.FLOAT;
            }
            case "EOF": {
                return TokenType.EOF;
            }
            case "UNKNOWN": {
                return TokenType.UNKNOWN;
            }
            default: {
                return TokenType.UNKNOWN;
            }
        }
    }

    //performs the parsing
    public void parse() {
        //declare start symbol, which starts the parsing process
        Program prg = new Program();


        //parse
        boolean success = prg.parseProgram(tokens);

        if (success) {
            //parsing succeeded
            System.out.println("Parsing successful. Printing syntax tree:");

            //get and print tree
            ArrayList<String> tree = prg.getTree();

            for (String s : tree) {
                System.out.println(s);
            }
        } else {
            System.out.println("Parsing failed");
        }
    }
}
