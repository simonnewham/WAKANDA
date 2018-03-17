import java.util.ArrayList;

public class program {
	// Program -> execute lround rround lcurly Statements rcurly

	Token [] grammar = {EXECUTE, LROUND, RROUND, LCURLY, STATEMENTS, RCURLY};
	int current = 0;
	ArrayList<String> tree = new ArrayList();//array of strings for printing the tree

	public program() {

	}

	public Token getNextToken() {
		if (current >= grammar.length) {
			return Token.NONE;
		} else {
			return grammar [++current];
		}
	}

	public String [] parseProgram() {
		for (int i = 0; i < grammar.length ; i++) {
			if (i == 4) {
				//parse Statements
				Statements stmts = new Statements();
				stmts.parse(4);
			} else {
				if (grammar[i] == tokens[i].getType()) {// tokens is a public static Token []
					tree.add(tokens[i].getValue());
				} else {
					System.out.println("Error");
				}
			}
		}

		return tree;
	}

}