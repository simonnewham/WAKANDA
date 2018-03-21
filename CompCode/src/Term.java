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

    //Term + Factor or Term / Factor
    if (term.parseTerm( tokens )) {
      if ( (tokens.get(0).getType() == TokenType.MULTIPLY) || (tokens.get(0).getType() == TokenType.DIVIDE)) {
        tokens.remove(0);
        if (factor.parseFactor( tokens )) {
          return true;
        }

      }

    }

    //Just a single Factor
    else {
      if (factor1.parseFactor( tokens )) {
        return true;
      }
    }

    return false;
  }

}
