/**
 * This TokenType enum taken from the lexer
 * @author Ross
 */
public enum TokenType implements Symbol {
    IDENTIFIER, // [a-zA-Z][a-zA-Z0-9_]*
    INT_CONST, // [0-9]+
    FLOAT_CONST, //[0-9]+.[0-9]+
    CHAR_CONST, //'ASCII Char'
    UNKNOWN, // character/token could not be processed
    EOF, //Input stream has been consumed
    STRING, // " [A-Z | a-z | 0-9] "

    // binary operators
    EQ, // ==
    NEQ, // !^
    LT, // <
    RT, // >
    LT_EQ, // <=
    GT_EQ, // >=
    PLUS, // +
    MINUS, // -
    MULTIPLY, // *
    DIVIDE, // /
    MOD, // %

    // reserved words
    EXECUTE, // main - relegate as ID (?)
    NUMS, // int
    CHAR, // char
    FLOAT, // float
    IF, // if
    OTHERWISE, // else
    EQUALS, // equals
    PRINT, // print
    INPUT,// input

    // punctuation
    QUOT, // "
    L_ROUND, // (
    R_ROUND, // )
    L_CURLY, // {
    R_CURLY, // }
    ASSIGN, // =
    NEGATIVE, // -
    COMMENT; //@

}
