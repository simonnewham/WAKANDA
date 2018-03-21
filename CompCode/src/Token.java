public class Token {

    private TokenType type; //token type
    private TokenAttribute attribute; //token attribute

    public Token(TokenType type, TokenAttribute attribute) {
        this.type = type;
        this.attribute = attribute;

    }

    public TokenType getType() {
        return type;
    }

    public TokenAttribute getAttribute() {
        return attribute;
    }

    /**
     * Returns a string presentation of this Token
     *
     * @author Ross
     */
    /*public String toString(){
    return type.toString() + " : " + attribute.toString();
    }*/
}
