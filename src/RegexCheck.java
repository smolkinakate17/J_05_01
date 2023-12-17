import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCheck {
    private static final Pattern EMAIL=Pattern.compile("[\\w.]+@[\\w.]+\\.\\w{2,4}");
    private static final Pattern PHONE=Pattern.compile("\\+7-?\\(?\\d{3}\\)?-?\\d{3}-?\\d{2}-?\\d{2}");
    private static final Pattern INN=Pattern.compile("(\\b\\d{10}\\b)|(\\b\\d{12}\\b)");
    private static final Pattern USERNAME=Pattern.compile("^[A-Za-z][A-Za-z\\d_$.]{7,}$");

    public static String check(String str){
        Matcher matcher= EMAIL.matcher(str);
        if(matcher.matches()){
            return "email";
        }
        matcher= PHONE.matcher(str);
        if(matcher.matches()){
            return "телефон";
        }
        matcher= INN.matcher(str);
        if(matcher.matches()){
            return "ИНН";
        }
        matcher= USERNAME.matcher(str);
        if(matcher.matches()){
            return "username";
        }
        return "none";
    }
    
}
