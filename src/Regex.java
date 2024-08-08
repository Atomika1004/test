import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regex {
    public static void main(String[] args) {
        String text = "У Ceni и Сани в сенях сом с усами";
        Pattern pattern = Pattern.compile("\\b[Cc][a-zA-Z]+\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }
}

