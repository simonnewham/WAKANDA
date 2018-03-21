import java.util.ArrayList;

public class Program {
	// Program -> execute lround rround lcurly Statements rcurly

	Symbol [] grammar = {TokenType.EXECUTE, TokenType.L_ROUND, TokenType.R_ROUND, TokenType.L_CURLY, NonTerminals.STATEMENT, TokenType.R_CURLY};
	int current = 0;
	ArrayList<String> tree = new ArrayList();//array of strings for printing the tree

	public Program() {

	}


	public boolean parseProgram(ArrayList<Token> lexer) {

		for (int i = 0; i < grammar.length ; i++) {
			if (i == 4) {
				//parse Statements
				Statement stmts = new Statement();

				//only parse what is needed
				if (!stmts.parseStatement(lexer)) {
					return false;
				}

			} else {
				if (grammar[i] == lexer.get(0)) {// tokens is a public static Token []
//					tree.add(lexer.get(0).getValue());
					lexer.remove(0);

				} else {
					System.out.println("Error in parsing program");
				}
			}
		}

		return true;
	}

	public ArrayList<String> getTree() {
		return tree;
	}

}
