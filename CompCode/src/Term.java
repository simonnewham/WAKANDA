import java.util.ArrayList;

public class Term {
    //Term -> Term multiply Factor
    //  | Term divide Factor
    //         | Factor
    public Term() {
    }

    public boolean parseTerm(ArrayList<Token> tokens) {
        //Instantiate objects
        Term term = new Term();
        Factor factor = new Factor();
        Factor factor1 = new Factor();

        //Just a single Factor
        if (factor1.parseFactor( tokens )) {
            return true;
        } else if (term.parseTerm( tokens )) {
            //Term + Factor or Term / Factor

            if ( (tokens.get(0).getType() == TokenType.MULTIPLY) || (tokens.get(0).getType() == TokenType.DIVIDE)) {
                tokens.remove(0);
                return factor.parseFactor( tokens );
            }
        }
        return false;
    }
}
