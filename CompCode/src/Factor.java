import java.util.ArrayList;

public class Factor {
    //Factor -> lround Expression rround
    // | numLiteral
    // | identifier
    // | floatLiteral

    public Factor() {
    }

    public boolean parseFactor(ArrayList<Token> tokens, int indent) {
        // System.out.println("Entered parseFactor");
        // System.out.println("tokens.get(0)" + tokens.get(0).getType() );
        //Check for enclosed expression
        if (tokens.get(0).getType() == TokenType.L_ROUND) {
            tokens.remove(0);

            Expression expr = new Expression();
            if (expr.parseExpr(tokens, indent + 1)) {
                if (tokens.get(0).getType() == TokenType.R_ROUND) {
                    tokens.remove(0);
                    return true;
                }
            }

        } else if ((tokens.get(0).getType() == TokenType.INT_CONST) || (tokens.get(0).getType() == TokenType.IDENTIFIER)
                   || (tokens.get(0).getType() == TokenType.FLOAT_CONST)) {

            /*for (int i = 0; i < indent; i++) {
                System.out.print("\t");
            }
            System.out.println(tokens.get(0).getAttribute().getString());*/
            tokens.remove(0);

            return true;
        }

        return false;
    }

}