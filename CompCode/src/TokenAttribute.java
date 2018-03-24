public class TokenAttribute {

    private int intVal; // int value of the token
    private float floatVal; // float value of the token
    private char charVal; // char value of the token
    private String variableVal; // id of the token

    public TokenAttribute() {
    }

    // construct TokenAttribute with an int value
    public TokenAttribute(int intVal) {
        this.intVal = intVal;
    }

    // construct TokenAttribute with a float value
    public TokenAttribute(float floatVal) {
        this.floatVal = floatVal;
    }

    // construct TokenAttribute with a char value
    public TokenAttribute(char charVal) {
        this.charVal = charVal;
    }

    // construct TokenAttribute with a string id
    public TokenAttribute(String var) {
        this.variableVal = var;
    }

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public float getFloatVal() {
        return floatVal;
    }

    public void setFloatVal(float floatVal) {
        this.floatVal = floatVal;
    }

    public char getCharVal() {
        return charVal;
    }

    public void setCharVal(char charVal) {
        this.charVal = charVal;
    }

    public String getIdVal() {
        return variableVal;
    }

    public void setIdVal(String idVal) {
        this.variableVal = idVal;
    }

    public String getString() {
        if (variableVal != null) {
            return variableVal;
        } else {
            if (intVal != 0) {
                return "" + intVal;
            } else if (floatVal != 0) {
                return "" + floatVal;
            } else if (charVal != 0) {
                return "" + charVal;
            } else {
                return "";
            }
        }
    }

    /*public String toString(){
    if (variableVal != null){
    return variableVal;
    }else{
    if(intVal != 0){
    return "" + intVal;
    }else if (floatVal != 0){
    return ""+ floatVal;
    }else if (charVal != 0){
    return "" + charVal;
    }else{
    return "0";
    }
    }
    }*/
}
