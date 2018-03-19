import java.util.ArrayList;

public class Expression {
	//Expression -> Expression plus Term
	//		 | Expression minus Term
	//               | Term
	
	ArrayList<String> tree = new ArrayList();//array of strings for printing the tree
	
	public Expression(){
		
	}
	public boolean parseExpr(ArrayList<TokenTypes> tokens){
		//         Term -> Term multiply Factor
		//             | Term divide Factor
		//             | Factor
		
		//Instantiated Expr and Term
		Expression expr = new Expression();
		Term term = new Term();
		Term term1 = new Term();
		
		if(expr.parseExp( tokens )){
			if(tokens.get(0)==TokenTypes.PLUS){
				tokens.remove(0);
				
				if (term.parseExp( tokens )){
					return True;
				}
			}
			if(tokens.get(0)==TokenTypes.MINUS){
				tokens.remove(0);
				
				if (term.parseExp( tokens )){
					return True;
				}
			}
		}
		else{
			if( term1.parseTerm(tokens){
				return True;
			}
		}
	}
}
