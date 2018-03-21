import java.util.ArrayList;

public class Expression {
    //Expression -> Expression plus Term
    //       | Expression minus Term
    //               | Term

    ArrayList<String> tree = new ArrayList();//array of strings for printing the tree

    public Expression() {

    }

    public boolean parseExpr(ArrayList<Token> tokens) {
        //         Term -> Term multiply Factor
        //             | Term divide Factor
        //             | Factor

        //Instantiated Expr and Term
        Expression expr = new Expression();
        Term term = new Term();
        Term term1 = new Term();

        if (expr.parseExpr(tokens)) {
            if (tokens.get(0).getType() == TokenType.PLUS) {
                tokens.remove(0);

                if (term.parseTerm(tokens)) {
                    return true;
                }
            }
            if (tokens.get(0).getType() == TokenType.MINUS) {
                tokens.remove(0);

                if (term.parseTerm(tokens)) {
                    return true;
                }
            }
        } else if (term1.parseTerm(tokens)) {
            return true;
        }

        return false;
    }
}
