
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
		Assignment assign = new Assignment();
		IfStatement ifstmt = new IfStatement();
		PrintStatement print = new PrintStatement();
		Statement nextStmt = new Statement();

		if (assign.parseAssignment(tokens) || ifstmt.parseIf(tokens) || print.parsePrint(tokens) || nextStmt.parseStatement(tokens)) {
			return true;
		} else {
			return false;
		}

	}
}