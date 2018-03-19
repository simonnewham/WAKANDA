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
        VARIABLE, // [a-zA-Z][a-zA-Z0-9_]*
	INT_CONST, // [0-9]+
	FLOAT_CONST, //[0-9]+.[0-9]+
	CHAR_CONST, //'ASCII Char'
	UNKNOWN, // character/token could not be processed
        EOF, //Input stream has been consumed
	
	// binary operators
	EQ, // ==
	NEQ, // !^
	LT, // <
	RT, // >
	LT_EQ, // <=
	RT_EQ, // >=
	PLUS, // +
	MINUS, // -
	TIMES, // *
	DIV, // /
	MOD, // %

	// reserved words
	EXECUTE, // main - relegate as ID (?)
	INT, // int
	CHAR, // char
	FLOAT, // float
	IF, // if
	OTHERWISE, // else
	EQUALS, // equals
        PRINT, // print
        INPUT,// input
        

	// punctuation
	LPAREN, // (
	RPAREN, // )
	LBRACKET, // [
	RBRACKET, // ]
	LBRACE, // {
	RBRACE, // }
        ASSIGN, // =
	NEGATIVE, // -
        
	

	// for error reporting
	STATEMENT,
	EXPRESSION,
	OPERATOR,
	TYPE
    
}
