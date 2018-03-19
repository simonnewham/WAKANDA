import java.util.ArrayList;

public class Program {
	// Program -> execute lround rround lcurly Statements rcurly

	TokenTypes [] grammar = {TokenTypes.EXECUTE, TokenTypes.L_ROUND, TokenTypes.R_ROUND, TokenTypes.L_CURLY, NonTerminals.STATEMENT, TokenTypes.R_CURLY};
	int current = 0;
	ArrayList<String> tree = new ArrayList();//array of strings for printing the tree

	public Program() {

	}

	public TokenTypes getNextToken() {
		if (current >= grammar.length) {
			return TokenTypes.NONE;
		} else {
			return grammar [++current];
		}
	}

	public boolean parseProgram(ArrayList<TokenTypes> lexer) {
		
		for (int i = 0; i < grammar.length ; i++) {
			if (i == 4) {
				//parse Statements
				Statement stmts = new Statement();
				
				//only parse what is needed
				if(!stmts.parseStatement(lexer)){
					return False;
				}
				
			} 
			else {
				if (grammar[i] == lexer.get(i)) {// tokens is a public static Token []
					tree.add(lexer.get(i).getValue());
					
				} else {
					System.out.println("Error in parsing program");
				}
			}
		}

		return True;
	}
	
	public ArrayList<String> getTree(){
		return tree;
	}

}
