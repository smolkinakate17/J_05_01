public class UnicodeCharInfo {
    private char c;

    private static final String DIGIT="DIGIT";
    private static final String LETTER_UPPER="LETTER_UPPER";
    private static final String LETTER_LOWER="LETTER_LOWER";
    private static final String SPACE="SPACE";
    private static final String OTHER="OTHER";

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public UnicodeCharInfo(char c) {
        this.c = c;
    }
    public int unicodeInt(){
        return c;
    }
    public String unicodeHex(){
        String str=Integer.toHexString(c).toUpperCase();
        if(str.length()==4){
            return "U+"+str;
        }
        if(str.length()==3){
            return "U+0"+str;
        }
        if (str.length()==2){
            return "U+00"+str;
        }
        return "U+000"+str;
    }
    public char nextChar(){
        return (char) ((int)c+1);
    }
    public char prevChar(){
        return (char) ((int)c-1);
    }
    public String charType(){
        if(((int)c>=65 && (int)c<=90)||((int)c>=97 &&(int)c<=122)||((int) c>=1025 && (int)c<=1105)){
            if (Character.isUpperCase(c)){
                return LETTER_UPPER;
            }
            if(Character.isLowerCase(c)){
                return LETTER_LOWER;
            }
        }

        if(Character.isDigit(c)){
            return DIGIT;
        }
        if(Character.isWhitespace(c)){
            return SPACE;
        }
        return OTHER;
    }
    public int alphabetNumber(){
        if(((int)c>=65 && (int)c<=90)){
            return (int)c-64;
        }
        if(((int)c>=97 &&(int)c<=122)){
            return (int) c-96;
        }
        return -1;
    }
}
