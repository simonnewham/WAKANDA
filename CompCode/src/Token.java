/*Enumerated Type for all tokens*/

public enum Token implements Symbol {
	EXECUTE("execute"),
	L_ROUND(")"),
	R_ROUND(")"),
	L_CURLY("{"),
	R_CURLY("}"),
	NUMS_LITERAL("nums"),
	FLOAT_LITERAL("float"),
	STRING_LITERAL("String"),
	EQUALS("="),
	PLUS("+"),
	MINUS("-"),
	MULTIPLY("*"),
	DIVIDE("/"),
	LESS_EQUAL("<="),
	GREATER_EQUAL(">="),
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