import java.util.ArrayList;

/*Class representing an assignment statement, e.g. "nums x = 12"
This grammar will have to be changed and the parse method as well.
right now this grammar does not account for the type at the start
of the assignment statement*/
public class Assignment {

    /*Assignment -> identifier equals Expression
             | identifier equals stringLit
             | identifier equals intLiteral
             | identifier equals floatLiteral*/
    // Token [] grammar = {};

    Assignment() {

    }

    public boolean parseAssignment(ArrayList<Token> tokens) {
        int token = 0;

        if (tokens.get(token).getType() == TokenType.IDENTIFIER) {
            token++;

            if (tokens.get(token).getType() == TokenType.EQUALS) {
                token++;

                TokenType type = tokens.get(token).getType();

                if (type == TokenType.INT_CONST || type == TokenType.FLOAT_CONST || type == TokenType.STRING) {
                    return true;

                } else {
                    Expression expr = new Expression();

                    //needn't parse whole ArrayList of tokens
                    return expr.parseExpr(tokens);
                }

            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
