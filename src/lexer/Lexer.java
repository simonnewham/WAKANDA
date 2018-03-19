/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

/**
 *
 * @author breydenmonyemoratho
 */

import java.io.BufferedReader;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
public class Lexer {
     private BufferedReader stream; //input stream reader
	private Token nextToken;
	private char nextChar;
        private  Token[] tokens;
        private LinkedList ll ;
//	private int lineNumber = 1; //current line number
//	private int columnNumber = 1; //current column number

	private final static Map<String, TokenType> reservedWords; //reserved words dictionary
	private final static Map<Character, TokenType> punctuation; //punctuation characters dictionary
	private final static Map<String, TokenType> operators; //operator characters dictionary
        private String line;
        
        
        
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
        
       
      

    private Lexer(FileReader file) throws IOException {
       this.stream = new BufferedReader(file);
       this.line=stream.readLine();
    }

    private char getChar() {
        return (char) ll.removeFirst();
    }
    private void createList(String l)
    {   ll = new LinkedList();
        for (char ch: l.toCharArray()) {
            ll.add(ch); 
          }
    }

    private void getT() {
         
        while((line!=null))
        {   createList(line);
            while(!ll.isEmpty()) {
                 nextChar=getChar();
            if (nextChar!='@')   // checks if its not a commented statement
            {    System.out.println(nextChar); 
                nextChar=getChar();
                while(Character.isLetter(nextChar))
                {   System.out.println(nextChar);
                     nextChar=getChar();
                }
            }
                     }
        }
       
    }
    
          public static void main(String[] args) throws FileNotFoundException, IOException 
        {    FileReader file=new FileReader("input.txt"); 
             Lexer w=new Lexer(file); 
             w.getT();
           // System.out.println(Lexer1.getChar("abcde"));
            
        }
    
    
}
