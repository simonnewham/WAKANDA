import java.util.ArrayList;

/*Class representing an assignment statement, e.g. "nums x = 12"*/
public class Assignment {

    /*Assignment -> nums identifier equals Expression
             | nums identifier equals intLiteral
             | float identifier equals Expression
             | float identifier equals floatLiteral
             | string identifier equals stringLiteral*/
    // Token [] grammar = {};

    Assignment() {

    }

    public boolean parseAssignment(ArrayList<Token> tokens) {
        if (tokens.get(0).getType() == TokenType.NUMS) {
            tokens.remove(0);

            if (tokens.get(0).getType() == TokenType.IDENTIFIER) {
                tokens.remove(0);

                if (tokens.get(0).getType() == TokenType.ASSIGN) {
                    tokens.remove(0);

                    if (tokens.get(0).getType() == TokenType.INT_CONST) {
                        tokens.remove(0);
                        return true;
                    } else {
                        Expression expr = new Expression();
                        return expr.parseExpr(tokens);
                    }
                }
            }
        } else if (tokens.get(0).getType() == TokenType.FLOAT) {
            tokens.remove(0);

            if (tokens.get(0).getType() == TokenType.IDENTIFIER) {
                tokens.remove(0);

                if (tokens.get(0).getType() == TokenType.ASSIGN) {
                    tokens.remove(0);

                    if (tokens.get(0).getType() == TokenType.FLOAT_CONST) {
                        tokens.remove(0);
                        return true;
                    } else {
                        Expression expr = new Expression();
                        return expr.parseExpr(tokens);
                    }
                }
            }
        }

        return false;

        /*if (tokens.get(token).getType() == TokenType.IDENTIFIER) {
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
        }*/
    }
}
