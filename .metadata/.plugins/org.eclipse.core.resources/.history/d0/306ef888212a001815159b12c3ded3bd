
import java.util.ArrayList;

public class Assignment {
	/*Assignment -> identifier equals Expression
			 | identifier equals stringLit
			 | identifier equals intLiteral
			 | identifier equals floatLiteral*/
	// Token [] grammar = {};

	Assignment() {

	}

	public boolean parseAssignment(ArrayList<Token> tokens) {
		int token = 0;

		if (tokens.get(token).getType() == TokenTypes.IDENTIFIER) {
			token++;

			if (tokens.get(token).getType() == TokenTypes.EQUALS) {
				token++;

				TokenTypes type = tokens.get(token).getType();

				if (type == TokenTypes.NUMS_LITERAL || type == TokenTypes.FLOAT_LITERAL || type == TokenTypes.STRING_LITERAL) {
					return true;
				} else {
					Expression expr = new Expression();

					//needn't parse whole ArrayList of tokens
					return Expression.parse(tokens);
				}

			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
