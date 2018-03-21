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

	public boolean parseIf(ArrayList<Token> tokens) {

		for (int i = 0; i < grammar.length; i++) {

			if (i == 5 || i == 8) { //check that statements are true

				if (stat.parseStatement(tokens) == true) { //tokens should already have been removed by statement method
					//tokens.remove(0);
				} else {
					return false;
				}
			} else if (i == 2) {
				//check if BoolCond parses
				if (!bool.parseBool(tokens)) {
					return false;
				}
			} else {
				if (grammar[i] == tokens.get(0).getType()) { //matches => remove element and run again
					tokens.remove(0);
				} else {
					return false;
				}
			}
		}

		return true;
	}
}
/*if(tokens.get(0) == TokenType.IF){
	tokens.remove(0);

	if(tokens.get(0) == TokenType.L_ROUND){
		//remove token
		if(bool.parseBool(tokens) == true){

			if(tokens.get(0) == TokenType.R_ROUND){

				if(tokens.get(0) == TokenType.L_CURLY){

					if(stat.parseStatement(tokens)==true){

						if(tokens.get(0) == TokenType.R_CURLY){

							if(tokens.get(0) == TokenType.OTHERWISE){

								if(tokens.get(0) == TokenType.L_CURLY){

									if(stat.parseStatement(tokens)==true){

										if(tokens.get(0) == TokenType.R_CURLY){
											return true;
										}
										else{
											return false;
										}
									}
									else{
										return false;
									}
								}
								else{
									return false;
								}
							}
							else{
								return true;
							}
						}
						else{
							return false;
						}
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	else{
		return false;
	}

}else{
	return false;
}*/
