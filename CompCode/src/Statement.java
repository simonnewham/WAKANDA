
/*Class reprensenting a Statement non-terminal
Ross van der Heyde*/

import java.util.ArrayList;

public class Statement {
	/*Statement -> Assignment
			| IfStatement
			| PrintStatement
			| Statement Statement*/

	Symbol [] grammar = {NonTerminals.ASSIGNMENT, NonTerminals.IF_STATEMENT, NonTerminals.PRINT_STATEMENT, NonTerminals.STATEMENT};

	Statement () {

	}

	public boolean parseStatement(ArrayList<Token> tokens) {
		Statement nextStmt = new Statement();

		// if (assign.parseAssignment(tokens) || ifstmt.parseIf(tokens) || print.parsePrint(tokens) || nextStmt.parseStatement(tokens)) {
		// 	return true;
		// } else {
		// 	return false;
		// }

		boolean ifParsed = false;
		boolean printParsed = false;
		boolean assignParsed = false;
		//look a head one token to try to parse correct NonTerminal

		TokenType lookAheadType = tokens.get(0).getType();

		if (lookAheadType == TokenType.IF) {
			IfStatement ifstmt = new IfStatement();
			ifParsed = ifstmt.parseIf(tokens);
		} else if (lookAheadType == TokenType.PRINT) {
			PrintStatement print = new PrintStatement();
			printParsed = print.parsePrint(tokens);
		} else if (lookAheadType == TokenType.FLOAT || lookAheadType == TokenType.NUMS) {
			Assignment assign = new Assignment();
			assignParsed = assign.parseAssignment(tokens);
		}

		if (ifParsed || printParsed || assignParsed) {
			return nextStmt.parseStatement(tokens) || true;
		} else {
			return false;
		}


	}
}