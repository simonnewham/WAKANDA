import java.util.ArrayList;

public class Expression {
    //Expression -> Term plus Expression
    //           | Term minus Expression
    //           | Term

    ArrayList<String> tree = new ArrayList();//array of strings for printing the tree

    public Expression() {

    }

    public boolean parseExpr(ArrayList<Token> tokens, int indent) {
        // System.out.println("Entered parseExpr");
        // Expression -> Term plus Expression
        //      | Term minus Expression
        //      | Term


        //Instantiated Expr and Term
        Expression rightE = new Expression();

        Term leftT = new Term();

        if (leftT.parseTerm(tokens, indent + 1, false)) {//this must not print

            if (tokens.get(0).getType() == TokenType.PLUS || tokens.get(0).getType() == TokenType.MINUS) {
                String op = tokens.get(0).getType() == TokenType.PLUS ? "+" : "-";
                tokens.remove(0);

                for (int i = 0; i < indent + 1; i++) {
                    System.out.print("\t");
                }
                System.out.println(op);

                //now print out term
                leftT.printTree(2);

                //check for Expr
                return rightE.parseExpr(tokens, indent);
            } else {
                //if we get here, E -> T has parsed successfully. not E -> T + E or E -> T - E
                //print term here
                leftT.printTree(0);
                return true;
            }
        }

        return false;
    }

}