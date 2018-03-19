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
public enum TokenType {

    /**
     * @param args the command line arguments
     */
        IDENTIFIER, // [a-zA-Z][a-zA-Z0-9_]*
	NUMS_LITERAL, // [0-9]+
	FLOAT_CONST, //[0-9]+.[0-9]+
	UNKNOWN, // character/token could not be processed
        EOF, //Input stream has been consumed
	
	// binary operators
	
	LESS_EQUAL, // <=
	GREATER_EQUAL, // >=
	PLUS, // +
	MULTIPLY, // *
	DIVIDE, // /
        EQUALS, // =
	MINUS, // -
	

	// reserved words
	EXECUTE, // main - relegate as ID (?)
        NUMS, //nums
	FLOAT, // float
	IF, // if
	OTHERWISE, // else
        PRINT, // print
        INPUT,// input
        

            // punctuation
            L_ROUND, // (
            R_ROUND, // )
            L_CURLY, // {
            R_CURLY, // }
      
        
	

	// for error reporting
	STATEMENT,
	EXPRESSION,
	OPERATOR,
	TYPE
    
}
