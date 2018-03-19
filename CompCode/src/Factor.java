import java.util.ArrayList;

public class Factor {
       //Factor -> lround Expression rround
		   // | numLiteral
		   // | identifier
       // | floatLiteral    
        public Factor(){
        }
        
        
        public boolean parseFactor(ArrayList<TokenTypes> tokens) {
           
            if(tokens.get(0) == TokenTypes.NUMS_LITERAL || tokens.get(0) == TokenTypes.IDENTIFIER || tokens.get(0) == TokenTypes.FLOAT_LITERAL){
              tokens.remove(0);
              return true;
            }
          
            else {
              if (tokens.get(0)==TokenTypes.L_ROUND){
                tokens.remove(0);
                
                Expression expr = new Expression(); 
                if (expr.parseExp( tokens )){
                  if (tokens.get(0)== TokenTypes.R_ROUND{
                    tokens.remove(0);
                    return True;
                  }
                }
                
              }
              else {
                return False;
              }
              
            }
          
  
}
