package study;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value={"2 + 1:true", ":false", " :false"}, delimiter = ':')
    void checkInputEmpty(String input, boolean expected) {
        assertThat(calculator.isNotEmpty(input)).isEqualTo(expected);
    }

    @Test
    void checkSplitAndSetValues() {
        String input = "2 + 1";
        assertThat(calculator.splitBlank(input)).contains("2", "+", "1");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 * 3:true", "1 @*:false", "!2 * 3:false"}, delimiter = ':')
    //@DisplayName(value = "기호만 있거나, 특수문자가 들어갔을 경우 false 반환하는지 확인")
    void checkInputValuable(String input, boolean expected) {
        assertThat(calculator.isRightExpression(input)).isEqualTo(expected);
    }

    @Test
    void transferStringToInt() {
        String stringNumber = "3";
        int expected = 3;
        assertThat(calculator.stringToInt(stringNumber)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value={"5:7:12", "3:6:9", "5:7:12"}, delimiter = ':')
    void testSum(int first, int second, int expected) {
        assertThat(calculator.sum(first, second)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value={"5:3:2", "3:6:-3", "9:1:8"}, delimiter = ':')
    void testSubtract(int first, int second, int expected) {
        assertThat(calculator.subtract(first, second)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value={"5:3:15", "3:6:18", "9:1:9"}, delimiter = ':')
    void testMultiply(int first, int second, int expected) {
        assertThat(calculator.multiply(first, second)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value={"5:3:1", "12:6:2", "9:1:9"}, delimiter = ':')
    void testDivide(int first, int second, int expected) {
        assertThat(calculator.divide(first, second)).isEqualTo(expected);
    }

    @Test
    // @DisplayName("0으로 나눴을 때 예외 발생 확인")
    void divideZeroException() {
        assertThatThrownBy(() -> {
            calculator.divide(9, 0);
        }).isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("/ by zero");
    }

    @ParameterizedTest
    @CsvSource(value={"2 + 3:5", "3 - 1:2", "4 * 2:8", "15 / 3:5"}, delimiter = ':')
    void checkCalculateCorrectly(String input, int expected) {
        String[] values = calculator.splitBlank(input);
        int left = calculator.stringToInt(values[0]);
        int right = calculator.stringToInt(values[2]);
        String operator = values[1];
        assertThat(calculator.calculate(left, operator, right)).isEqualTo(expected);
    }

    @Test
    void getResult() {
        String input = "2 + 3 * 4 / 10";
        int expected = 2;
        String[] values = input.split(" ");
        assertThat(calculator.getResult(values)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value={"2 + 7 * 1 - 4 / 5:1", "2 + 7 * 1 - 4 ! 5:계산식 오류"}, delimiter = ':')
    void runStringCalculator(String input, String expected) {
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(calculator.runStringCalculator()).isEqualTo(expected);
    }

}
