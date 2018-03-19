/*Enumerated Type for all tokens*/

public enum TokenTypes implements Symbol {
	EXECUTE("execute"),
	L_ROUND("("),
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
	NONE("none"),
	IF("if"),
	PRINT("print"),
	OTHERWISE("otherwise");

	private final String tokenValue;

	private TokenTypes(String value) {
		tokenValue = value;
		
	}

	//public String getType() {
		//return tokenType;
	//}

	public String getValue() {
		return tokenValue;
	}

	//public String toString() {
		//return tokenType + ":" + tokenValue;
	//}

}
