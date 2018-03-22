import java.util.ArrayList;

public class Factor {
    //Factor -> lround Expression rround
    // | numLiteral
    // | identifier
    // | floatLiteral

    public Factor() {
    }

    public boolean parseFactor(ArrayList<Token> tokens) {
        //Check for nums identifier of float
        if ((tokens.get(0).getType() == TokenType.INT_CONST) || (tokens.get(0).getType() == TokenType.IDENTIFIER)
                || (tokens.get(0).getType() == TokenType.FLOAT_CONST)) {
            tokens.remove(0);
            return true;
        } else //Check for enclosed expression
            if (tokens.get(0).getType() == TokenType.L_ROUND) {
                tokens.remove(0);

                Expression expr = new Expression();
                if (expr.parseExpr(tokens)) {
                    if (tokens.get(0).getType() == TokenType.R_ROUND) {
                        tokens.remove(0);
                        return true;
                    }
                }

            }

        return false;
    }

}
