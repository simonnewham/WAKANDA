import java.util.ArrayList;

//Simon Newham
//Class to verify boolean conditions
public class BoolCond {

  /*BoolCond ->  identifier leq intLiteral
    | identifier geq intLiteral
    | intLiteral leq identifier
    | intLiteral geq identifier
    | identifier leq identifier
    | identifier geq identifier
    | identifier leq floatLiteral
    | identifier geq floatLiteral
    | floatLiteral leq identifier
    | floatLiteral geq identifier*/
  public BoolCond() {

  }

  public boolean parseBool(ArrayList<Token> tokens) {
    // System.out.println("Entered parseBool");
    if (tokens.get(0).getType() == TokenType.IDENTIFIER || tokens.get(0).getType() == TokenType.INT_CONST
        || tokens.get(0).getType() == TokenType.FLOAT_CONST) {
      tokens.remove(0);

      if (tokens.get(0).getType() == TokenType.GT_EQ || tokens.get(0).getType() == TokenType.LT_EQ) {
        tokens.remove(0);

        if (tokens.get(0).getType() == TokenType.IDENTIFIER ||
            tokens.get(0).getType() == TokenType.INT_CONST ||
            tokens.get(0).getType() == TokenType.FLOAT_CONST) {
          tokens.remove(0);
          return true;
        } else {
          return false;
        }
      } else {
        return false;
      }
    } else {
      return false;
    }

  }
}
