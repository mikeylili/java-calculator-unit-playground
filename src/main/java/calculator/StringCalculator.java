package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    int split(String expression) {
        Pattern pattern = Pattern.compile("//(.*?)\n");
        Matcher matcher = pattern.matcher(expression);
        String str = "";

        if (matcher.find()) {
            str = matcher.group(1);
            expression = expression.replace("//" + str + "\n", "");
        }

        String div = ",|:|[" + Pattern.quote(str) + "]";
        String[] tokens = expression.split(div);

        int sum = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                sum += Integer.parseInt(token.trim());
            }
        }
        return sum;
    }
}