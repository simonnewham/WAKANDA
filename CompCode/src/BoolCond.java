import java.util.ArrayList;

//Simon Newham
//Class to verify boolean conditions 

public class BoolCond {

	/*BoolCond ->  identifier leq intLiteral
	  | identifier geq intLiteral
	  | intLiteral leq identifier
	  | intLiteral geq identifier
	  | identifier leq identifier
	  | identifier geq identifier
	  | identifier leq floatLiteral
	  | identifier geq floatLiteral
	  | floatLiteral leq identifier
	  | floatLiteral geq identifier*/
	
	public BoolCond(){
		
	}
	
	public boolean parseBool(ArrayList<TokenTypes> tokens){
		
		if(tokens.get(0)==TokenTypes.IDENTIFIER || tokens.get(0)==TokenTypes.NUMS_LITERAL ||tokens.get(0)==TokenTypes.FLOAT_LITERAL){
			tokens.remove(0);
			
			if(tokens.get(0) == TokenTypes.GREATER_EQUAL || tokens.get(0)==TokenTypes.LESS_EQUAL){
				tokens.remove(0);
				
				if(tokens.get(0)==TokenTypes.IDENTIFIER || tokens.get(0)==TokenTypes.NUMS_LITERAL ||tokens.get(0)==TokenTypes.FLOAT_LITERAL){
					tokens.remove(0);
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
}
