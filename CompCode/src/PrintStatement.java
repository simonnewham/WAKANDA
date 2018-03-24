//Simon Newham
//Class to verify print statement
import java.util.ArrayList;

public class PrintStatement {

    /*PrintStatement -> print lround stringLit rround
    | print lround identifier rround
    | print lround numLiteral rround
    | print lround floatLiteral rround*/

    public PrintStatement() {

    }
    //make sure input follows rules

    public boolean parsePrint(ArrayList<Token> input, int indent) {
        // System.out.println("Entered parsePrint");
        if (input.get(0).getType() == TokenType.PRINT) {
            input.remove(0);

            for (int i = 0; i < indent; i++) {
                System.out.print("\t");
            }
            System.out.println("PRINT");

            if (input.get(0).getType() == TokenType.L_ROUND) {
                input.remove(0);

                TokenType two = input.get(0).getType();

                if (two == TokenType.STRING || two == TokenType.INT_CONST || two == TokenType.FLOAT_CONST || two == TokenType.IDENTIFIER) {
                    //print token for syntax tree
                    for (int i = 0; i < indent + 1; i++) {
                        System.out.print("\t");
                    }
                    System.out.println(input.get(0).getAttribute().getString());
                    input.remove(0);

                    //parse closing round bracket
                    if (input.get(0).getType() == TokenType.R_ROUND) {
                        input.remove(0);
                        return true;
                    } else {
                        System.out.println("Error: Missing ) in print statement");
                        return false;
                    }
                } else {
                    System.out.println("Error: attempting to print invlalid token");
                    return false;
                }
            } else {
                System.out.println("Error: Missing ( in print statement");
                return false;
            }

        } else {
            System.out.println("Error: Could not parse statement");
            return false;
        }

    }
}
