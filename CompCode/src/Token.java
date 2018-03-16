/*Enumerated Type for all tokens*/

public enum Token {
	EXECUTE("execute"),
	LROUND(")"),
	RROUND(")"),
	LCURLY("{"),
	RCURLY("}"),
	NUMSLITERAL("nums"),
	FLOATLITERAL("float"),
	STRINGLITERAL("String"),
	EQUALS("="),
	PLUS("+"),
	MINUS("-"),
	MULTIPLY("*"),
	DIVIDE("/"),
	LESSEQUAL("<="),
	GREATEREQUAL(">="),
	IDENTIFIER("id"),
	NONE("none");


	private final String tokenValue;

	private Token(String value) {
		tokenValue = value;
	}

	public String toString() {
		return tokenValue;
	}
}