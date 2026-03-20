package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    int split(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        Matcher matcher = Pattern.compile("//(.*?)\n").matcher(expression);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            delimiter += "|" + Pattern.quote(customDelimiter);
            expression = expression.substring(matcher.end());
        }

        String[] tokens = expression.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            try {
                int number = Integer.parseInt(token.trim());
                if (number < 0) {
                    throw new RuntimeException();
                }
                sum += number;
            } catch (NumberFormatException e) {
                throw new RuntimeException();
            }
        }
        return sum;
    }
}