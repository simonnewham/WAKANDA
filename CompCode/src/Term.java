import java.util.ArrayList;

public class Term {
    //Term -> Term multiply Factor
    //  | Term divide Factor
    //         | Factor
    public Term() {
    }

    public boolean parseTerm(ArrayList<Token> tokens, int indent) {
        // System.out.println("Entered parseTerm");
        //Instantiate objects
        Term term = new Term();

        Factor factor = new Factor();

        //first check Term -> Term * Factor and Term -> Term / Factor
        if (factor.parseFactor( tokens, indent + 1 )) {
            if ((tokens.get(0).getType() == TokenType.MULTIPLY) || (tokens.get(0).getType() == TokenType.DIVIDE)) {
                // String op = tokens.get(0).getType() == TokenType.MULTIPLY ? "*" : "/";
                tokens.remove(0);

                /*for (int i = 0; i < indent; i++) {
                    System.out.print("\t");
                }
                System.out.println(op);*/

                return term.parseTerm( tokens, indent + 1 );
            } else {
                return true;
            }
        }
        return false;
    }
}