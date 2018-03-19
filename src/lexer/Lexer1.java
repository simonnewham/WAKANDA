/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

import java.io.BufferedReader;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author breydenmonyemoratho
 */
public class Lexer1 {
    private BufferedReader stream; //input stream reader
	private Token nextToken;
	private char nextChar;
        private  static int pos=0;
        private static   char[] array;
//	private int lineNumber = 1; //current line number
//	private int columnNumber = 1; //current column number

	private final static Map<String, TokenType> reservedWords; //reserved words dictionary
	private final static Map<Character, TokenType> punctuation; //punctuation characters dictionary
	private final static Map<String, TokenType> operators; //operator characters dictionary
        public String line;
        
        
        
	static {
		reservedWords = new HashMap<String, TokenType>();

		reservedWords.put("float", TokenType.FLOAT);
                reservedWords.put("if", TokenType.IF);
		reservedWords.put("else", TokenType.OTHERWISE);
		reservedWords.put("Execute", TokenType.EXECUTE);
                reservedWords.put("print", TokenType.PRINT);
		reservedWords.put("input", TokenType.INPUT);
                reservedWords.put("nums", TokenType.NUMS);
	
       

		punctuation = new HashMap<Character, TokenType>();
		punctuation.put('(', TokenType.L_ROUND);
		punctuation.put(')', TokenType.R_ROUND);
		punctuation.put('[', TokenType.L_CURLY);
		punctuation.put(']', TokenType.R_CURLY);
		

                
        
		

		operators = new HashMap<String, TokenType>();
	
		operators.put("<=", TokenType.LESS_EQUAL); 
		operators.put(">=", TokenType.GREATER_EQUAL);
		operators.put("+", TokenType.PLUS); 
		operators.put("-", TokenType.MINUS);   
		operators.put("*", TokenType.MULTIPLY);   
		operators.put("/", TokenType.DIVIDE);   

	}
        
        public Lexer1(FileReader file) throws FileNotFoundException, IOException {
		this.stream = new BufferedReader(file);
                
                line=stream.readLine();
             
           
		
	}
        public void getT() throws IOException
        {   //    create a list of tokens
           
           while(!line.equals(null))
           {    System.out.println("here1");
               if (line.charAt(0)!='@')   // do not process the first line
                {  pos=0;
                   nextChar=getChar(line);
                   System.out.println(nextChar);
                   pos++;
                 System.out.println("here2");
                // to check if you reached the end of line or processed the entire line
		while (nextChar!='\n' || pos!= (line.toCharArray().length-1))
                {     System.out.println("here3");
                    // skip th whitespace and tabs
                    
                    while ( nextChar=='\t' || nextChar==' ')
                    {       nextChar=getChar(line); 
                            pos++;
                            
                    }
                    // identifier or reserved word ([a-zA-Z][a-zA-Z0-9_]*)
                    if (Character.isLetter(nextChar))
                   {   // create new idVal starting with first char of identifier
			String current = Character.toString((char) nextChar);
			 System.out.println("here4");
			nextChar = getChar(line);
                        pos++;
                         

			// include remaining sequence of chars that are letters, digits, or _
			while (Character.isLetterOrDigit(nextChar)) {
				current += (char) nextChar;
			System.out.println("here8");
				nextChar = getChar(line);
                                pos++;
			}

			// check if identifier is a reserved word
			TokenType type = reservedWords.get(current);

			if (type != null)
                        {   nextToken= new Token(type, new TokenAttribute());
                            System.out.println(nextToken.getType()+"__"+nextToken.getAttribute());
                        
                        }
                        else
                        { // token is an identifier
                            nextToken= new Token(TokenType.IDENTIFIER, new TokenAttribute(current)); 
                            System.out.println(nextToken.getType()+"__"+nextToken.getAttribute());
                        }
			

			 
                   }
                   // deals with nums and floats
//                   if (Character.isDigit(nextChar)) {
//
//			// create string representation of number
//			String numString = Character.toString((char) nextChar);
//			
//			nextChar = getChar(line);
//                         
//
//			// concatenate remaining sequence of digits
//			while (Character.isDigit(nextChar)) {
//				numString += (char) nextChar;
//				
//				nextChar = getChar(line);
//                             
//			}
//			
//			if(nextChar == '.'){
//				//stream.mark(0);
//				nextChar = getChar(line);
//                                
//				
//				if(Character.isDigit(nextChar)){
//					numString += '.';
//					// concatenate remaining sequence of digits
//					while (Character.isDigit(nextChar)) {
//						numString += (char) nextChar;
//						
//						nextChar = getChar(line);
//                                             
//					}
//					
//					 nextToken= new Token(TokenType.FLOAT_CONST, new TokenAttribute(Float.parseFloat(numString)));
//				}
//				while(!Character.isWhitespace(nextChar)){
//					
//					numString += nextChar;
//					nextChar = getChar(line);
//                                       
//				}
//				
//				nextToken=new Token(TokenType.UNKNOWN, new TokenAttribute());
//			}
//
//			// return integer literal token
//			nextToken= new Token(TokenType.NUMS_LITERAL, new TokenAttribute(Integer.parseInt(numString)));
//		}
                   
                  // deals with punctuations

//                        if (nextChar==')')
//                              {  nextToken=new Token(TokenType.R_ROUND, new TokenAttribute());
//                              }
//                        if (nextChar=='(')
//                        {  nextToken=new Token(TokenType. L_ROUND, new TokenAttribute());
//                        }
//                        if (nextChar=='{')
//                        {  nextToken=new Token(TokenType.L_CURLY, new TokenAttribute());
//                        }
//                        if (nextChar=='}')
//                        {  nextToken=new Token(TokenType. R_CURLY, new TokenAttribute());
//                        }
                
                   // deals with operators
                        /*
                        LESS_EQUAL, // <=
                        GREATER_EQUAL, // >=
                        PLUS, // +
                        MULTIPLY, // *
                        DIVIDE, // /
                        EQUALS, // =
                        MINUS, // -*/
                        
                        		// check for binops
//		switch (nextChar) {
//		
//
//
//
//		case '=':
//			
//		
//
//			// check if next char is '=' 
//			if (nextChar == '=') {
//				
//				nextToken= new Token(TokenType.EQUALS, new TokenAttribute());
//			}
//			
//		
//		
//
//		case '<':
//			
//			nextChar = getChar(line);
//                      
//
//			
//			if (nextChar == '=') {
//				
//				nextToken= new Token(TokenType.LESS_EQUAL, new TokenAttribute());
//                        }
//
//		case '>':
//			
//			nextChar = getChar(line);
//                      
//
//			// check if next char is '<' to match '<=' binop
//			if (nextChar == '=') {
//				
//				nextToken= new Token(TokenType.GREATER_EQUAL, new TokenAttribute());
//			} 
//
//		case '+':
//		
//               
//			
//			nextToken=new Token(TokenType.PLUS, new TokenAttribute());
//
//		case '-':
//		
//			
//		nextToken= new Token(TokenType.MINUS, new TokenAttribute());
//
//		case '*':
//			
//		
//			nextToken= new Token(TokenType.MULTIPLY, new TokenAttribute());
//
//		
//
//
//		}
                   nextChar = getChar(line);    // to check if you reached the end of line or processed the entire line
                    pos++;
                }
                
               }
               
           }
           line=stream.readLine();
           
          
        }
        
        
        
        public static char getChar(String line)
        {    array=line.toCharArray();
            
             //System.out.println(Arrays.toString(array));
             return array[pos];
            
        }
        public static void main(String[] args) throws FileNotFoundException, IOException 
        {     FileReader file=new FileReader("input.txt"); 
             Lexer1 w=new Lexer1(file); 
             w.getT();
           // System.out.println(Lexer1.getChar("abcde"));
            
        }
	
    
}
