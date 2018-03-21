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

    public boolean parsePrint(ArrayList<Token> input) {

        if (input.get(0).getType() == TokenType.PRINT) {
            input.remove(0);

            if (input.get(0).getType() == TokenType.L_ROUND) {
                input.remove(0);

                TokenType two = input.get(0).getType();

                if (two == TokenType.STRING || two == TokenType.INT_CONST || two == TokenType.FLOAT_CONST || two == TokenType.IDENTIFIER) {
                    input.remove(0);

                    if (input.get(0).getType() == TokenType.R_ROUND) {
                        input.remove(0);
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } else {
            return false;
        }

    }
}
