package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    @Test

    void Test1 (){
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.split("5,1:4");
        assertEquals(10, result);
    }

    @DisplayName("커스텀 구분자를 가지는 문자열을 전달하는 경우")
    @Test
    void Test2() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.split("//;\n3;1;4");
        assertEquals(8, result);
    }

    @DisplayName("음수를 전달하는 경우 RuntimeException 예외를 Throw한다.")
    @Test
    void Test3() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThrows(RuntimeException.class, () -> {
            stringCalculator.split("-1,2,3");
        });
    }

    @DisplayName("숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 Throw한다.")
    @Test
    void Test4() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThrows(RuntimeException.class, () -> {
            stringCalculator.split("1,a,3");
        });
    }
}