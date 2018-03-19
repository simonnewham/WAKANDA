import java.util.ArrayList;

//Class to verify if statement
//Simon Newham

public class IfStatement {
	//IfStatement -> if lround BoolCond rround lcurly Statement rcurly otherwise lcurly Statement rcurly
	
	BoolCond bool = new BoolCond();
	Statement stat = new Statement();
	
	Symbol [] grammar = {TokenTypes.IF, TokenTypes.L_ROUND, TokenTypes.R_ROUND, TokenTypes.L_CURLY, NonTerminals.STATEMENT,
					TokenTypes.R_CURLY,	TokenTypes.OTHERWISE, TokenTypes.L_CURLY, NonTerminals.STATEMENT, TokenTypes.R_CURLY };
	
	public IfStatement(){
		
	}
	
	public boolean parseIf(ArrayList<TokenTypes> tokens){
		
		for(int i=0; i< grammar.length; i++){
			
			if(i==4 || i ==8){ //check that statements are true 
				
				if(stat.parseStatement(tokens)==true){ //tokens should already have been removed by statement method
					//tokens.remove(0);
				}
				else{
					return false;
				}
			} 
			else{
				if(grammar[i] == tokens.get(0)){ //matches => remove element and run again
					tokens.remove(0);
				}
				else{
					return false;
				}
			}
		}
		
		return true;
	}
}
		/*if(tokens.get(0) == TokenTypes.IF){
			tokens.remove(0);
			
			if(tokens.get(0) == TokenTypes.L_ROUND){
				//remove token
				if(bool.parseBool(tokens) == true){
					
					if(tokens.get(0) == TokenTypes.R_ROUND){
						
						if(tokens.get(0) == TokenTypes.L_CURLY){
							
							if(stat.parseStatement(tokens)==true){
								
								if(tokens.get(0) == TokenTypes.R_CURLY){
									
									if(tokens.get(0) == TokenTypes.OTHERWISE){
										
										if(tokens.get(0) == TokenTypes.L_CURLY){
											
											if(stat.parseStatement(tokens)==true){
												
												if(tokens.get(0) == TokenTypes.R_CURLY){
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
