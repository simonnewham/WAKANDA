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

    public boolean parseAssignment(ArrayList<Token> tokens, int indent) {
        // System.out.println("Entered parseAssignment");
        String assign = "=";
        String leftChild = "leftChild";
        String rightChild = "rightChild";

        if (tokens.get(0).getType() == TokenType.NUMS) {
            tokens.remove(0);

            if (tokens.get(0).getType() == TokenType.IDENTIFIER) {
                leftChild = tokens.get(0).getAttribute().getString();
                tokens.remove(0);

                if (tokens.get(0).getType() == TokenType.ASSIGN) {
                    tokens.remove(0);

                    Expression expr = new Expression();
                    if (expr.parseExpr(tokens, indent + 1)) {
                        return true;
                    } else if (tokens.get(0).getType() == TokenType.INT_CONST) {
                        rightChild = tokens.get(0).getAttribute().getString();
                        printTree(assign, leftChild, rightChild, indent);
                        tokens.remove(0);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } else if (tokens.get(0).getType() == TokenType.FLOAT) {
            tokens.remove(0);

            if (tokens.get(0).getType() == TokenType.IDENTIFIER) {
                leftChild = tokens.get(0).getAttribute().getString();
                tokens.remove(0);

                if (tokens.get(0).getType() == TokenType.ASSIGN) {
                    tokens.remove(0);

                    Expression expr = new Expression();
                    if (expr.parseExpr(tokens, indent + 1)) {
                        return true;
                    } else if (tokens.get(0).getType() == TokenType.FLOAT_CONST) {
                        rightChild = tokens.get(0).getAttribute().getString();
                        printTree(assign, leftChild, rightChild, indent);
                        tokens.remove(0);
                        return true;
                    } else {
                        return false;
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

    private void printTree(String assign, String left, String right, int indent) {
        for (int i = 0; i < indent ; i++) {
            System.out.print("\t");
        }
        System.out.println(assign);

        for (int i = 0; i < indent + 1; i++) {
            System.out.print("\t");
        }
        System.out.println(left);

        for (int i = 0; i < indent + 1; i++) {
            System.out.print("\t");
        }
        System.out.println(right);
    }
}
