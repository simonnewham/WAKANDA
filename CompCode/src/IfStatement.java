import java.util.ArrayList;

//Class to verify if statement
//Simon Newham

public class IfStatement {
	//IfStatement -> if lround BoolCond rround lcurly Statement rcurly otherwise lcurly Statement rcurly

	BoolCond bool = new BoolCond();
	Statement stat = new Statement();

	Symbol [] grammar = {TokenType.IF, TokenType.L_ROUND, NonTerminals.BOOL_COND, TokenType.R_ROUND, TokenType.L_CURLY, NonTerminals.STATEMENT,
	                     TokenType.R_CURLY,	TokenType.OTHERWISE, TokenType.L_CURLY, NonTerminals.STATEMENT, TokenType.R_CURLY
	                    };

	public IfStatement() {

	}

	public boolean parseIf(ArrayList<Token> tokens, int indent) {
		// System.out.println("Entered parseIf");

		for (int i = 0; i < indent; i++) {
			System.out.print("\t");
		}
		System.out.println("if");

		for (int i = 0; i < grammar.length; i++) {

			if (i == 5 || i == 9) { //check that statements are true

				if (stat.parseStatement(tokens, indent + 1) == true) { //tokens should already have been removed by statement method
					//tokens.remove(0);
				} else {
					return false;
				}
			} else if (i == 2) {
				//check if BoolCond parses
				if (!bool.parseBool(tokens, indent + 1)) {
					return false;
				}
			} else {
				if (grammar[i] == tokens.get(0).getType()) { //matches => remove element and run again
					tokens.remove(0);

					if (i == 6) {
						for (int j = 0; j < indent; j++) {
							System.out.print("\t");
						}
						System.out.println("otherwise");
					}

				} else {
					return false;
				}
			}
		}

		return true;
	}
}

