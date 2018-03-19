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
		if(tokens.get(0) == TokenTypes.TERM){
	}
}
