import java.util.ArrayList;

public class Term {
    //for printing the parse tree
    private String root = "root"; // either * or /
    private Factor leftF; // Factor
    private Term rightT = null; // Term or nothing
    private int tabs = 0;
    // Term -> Factor multiply Term
    //     | Factor divide Term
    //     | Factor
    public Term() {
    }

    public boolean parseTerm(ArrayList<Token> tokens, int indent, boolean print) {
        tabs = indent;
        // System.out.println("Entered parseTerm");
        //Instantiate objects
        leftF = new Factor();

        //first check Term -> Term * Factor and Term -> Term / Factor
        if (leftF.parseFactor( tokens, indent)) {
            if ((tokens.get(0).getType() == TokenType.MULTIPLY) || (tokens.get(0).getType() == TokenType.DIVIDE)) {
                root = tokens.get(0).getType() == TokenType.MULTIPLY ? "*" : "/";
                tokens.remove(0);

                if (print) {
                    for (int i = 0; i < indent; i++) {
                        System.out.print("\t");
                    }
                    System.out.println(root);

                    //now print out Factor on indent + 1
                    leftF.printTree(0);
                }

                //then term
                rightT = new Term();
                return rightT.parseTerm( tokens, indent, print);
            } else {
                //if we get here, T -> F has been parsed sucessfully, not T -> F * T or T -> F / T
                if (print) {
                    leftF.printTree(0);
                }
                return true;
            }
        }
        return false;
    }

    public void printTree(int extra) {
        if (! root.equals("root")) {
            for (int i = 0; i < tabs + extra ; i++ ) {
                System.out.print("\t");
            }
            System.out.println(root);
        }

        if (leftF != null) {
            leftF.printTree(1); //factor
        }

        if (rightT != null) {
            rightT.printTree(-1);
        }

    }
}