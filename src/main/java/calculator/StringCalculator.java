package calculator;

public class StringCalculator {
    int split(String expression){
        String[] tokens = expression.split("[,|:]");
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
