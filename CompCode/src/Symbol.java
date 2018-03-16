/*This is interface is so Tokens and NonTerminals can be
stored in the same array. enums can not inherit a class but they
can implement an interface.*/

public interface Symbol {
	public String toString();
}