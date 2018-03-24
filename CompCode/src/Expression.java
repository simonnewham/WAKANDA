import java.util.ArrayList;

public class Expression {
    //Expression -> Expression plus Term
    //       | Expression minus Term
    //               | Term

    ArrayList<String> tree = new ArrayList();//array of strings for printing the tree

    public Expression() {

    }

    public boolean parseExpr(ArrayList<Token> tokens, int indent) {
        // System.out.println("Entered parseExpr");
        // Expression -> Expression plus Term
        //       | Expression minus Term
        //       | Term


        //Instantiated Expr and Term
        Expression expr = new Expression();

        Term term = new Term();

        if (term.parseTerm(tokens, indent + 1)) {

            if (tokens.get(0).getType() == TokenType.PLUS || tokens.get(0).getType() == TokenType.MINUS) {
                // String op = tokens.get(0).getType() == TokenType.PLUS ? "+" : "-";
                tokens.remove(0);

                /*for (int i = 0; i < indent; i++) {
                    System.out.print("\t");
                }
                System.out.println(op);*/

                //now term should print out

                // System.out.println("Parsed + or -");
                //check for Expr
                return expr.parseExpr(tokens, indent + 1);
            } else {
                return true;
            }
        }

        return false;
    }

}