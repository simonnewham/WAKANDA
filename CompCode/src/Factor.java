import java.util.ArrayList;

public class Factor {
// Factor -> lround Expression rround
//           | numLiteral
//           | identifier
//           | floatLiteral
    private String literal = "literal";
    private int tabs = 0;

    public Factor() {
    }

    public boolean parseFactor(ArrayList<Token> tokens, int indent) {
        tabs = indent;

        //Check for enclosed expression
        if (tokens.get(0).getType() == TokenType.L_ROUND) {
            tokens.remove(0);

            Expression expr = new Expression();
            if (expr.parseExpr(tokens, indent)) {
                if (tokens.get(0).getType() == TokenType.R_ROUND) {
                    tokens.remove(0);
                    return true;
                }
            }

        } else if ((tokens.get(0).getType() == TokenType.INT_CONST) || (tokens.get(0).getType() == TokenType.IDENTIFIER)
                   || (tokens.get(0).getType() == TokenType.FLOAT_CONST)) {

            literal = tokens.get(0).getAttribute().getString();
            tokens.remove(0);

            return true;
        }

        return false;
    }

    public void printTree(int extra) {
        // System.out.println("print Tree. extra:" + extra);
        if (!literal.equals("literal")) {
            for (int i = 0; i < tabs + extra; i++) {
                System.out.print("\t");
            }
            System.out.println(literal);
        }
    }

}