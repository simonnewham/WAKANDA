//Simon Newham 
//Class to verify print statement

import java.util.ArrayList;

public class Printstatement {
	/*PrintStatement -> print lround stringLit rround
	| print lround identifier rround
	| print lround numLiteral rround
	| print lround floatLiteral rround*/
	
	public Printstatement(){
			
	}
	//make sure input follows rules
	public boolean parsePrint(ArrayList<TokenTypes> input){
		
		if(input.get(0) == TokenTypes.PRINT){
			input.remove(0);
			
			if (input.get(0) == TokenTypes.L_ROUND){
				input.remove(0);
				
				TokenTypes two = input.get(0);
				
				if(two == TokenTypes.STRING_LITERAL || two == TokenTypes.NUMS_LITERAL || two == TokenTypes.FLOAT_LITERAL || two == TokenTypes.IDENTIFIER){
					input.remove(0);
					
					if(input.get(0) == TokenTypes.R_ROUND){
						input.remove(0);
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
			return false;
		}
	
	}
}
