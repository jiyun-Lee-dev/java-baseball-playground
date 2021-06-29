package baseball;

import baseball.BaseballPlayground;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballPlaygroundTest {
    public BaseballPlayground baseballPlayground;

    @BeforeEach
    void setUp() {
        baseballPlayground = new BaseballPlayground();
    }

    @Test
    void checkRandomNumbers() {
        assertThat(baseballPlayground.randomNumbers.length()).isEqualTo(3);
    }

    @Test
    void changeSetToIntArray() {
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(2);
        set.add(8);
        String actual = baseballPlayground.changeSetToString(set);
        assertThat(actual).contains("3", "2", "8");
    }

    @Test
    void changeStringToIntArray() {
        String string = "487";
        int[] actual = baseballPlayground.changeStringToIntArray(string);
        assertThat(actual).containsExactly(4, 8, 7);
    }

    @ParameterizedTest
    @CsvSource(value = {"245:false", "499:true"}, delimiter = ':')
    void checkDuplicateNumber(String input, boolean expected) {
        boolean actual = baseballPlayground.hasDuplicateNumber(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value= {"201:true", "293:false"}, delimiter = ':')
    void checkZero(String input, boolean expected) {
        boolean actual = baseballPlayground.hasZero(input);
        assertThat(actual).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource(value = {"182:true", "3091:false", "309:false", "225:false"}, delimiter = ':')
    void checkInputIsValid(String input, boolean expected) {
        boolean actual = baseballPlayground.isInputValid(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"345:10", "395:11", "349:20", "379:30", "937:03", "164:00"}, delimiter = ':')
    void checkStrikesAndBalls(String inputNumbers, String expectedString) {
        String originalNumbers = "379";
        int[] expected = {expectedString.charAt(0) - '0', expectedString.charAt(1) - '0'};
        int[] actual = baseballPlayground.getStrikesAndBalls(originalNumbers, inputNumbers);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"345:1스트라이크", "395:1볼 1스트라이크", "349:2스트라이크", "379:3스트라이크", "937:3볼", "164:낫싱"}, delimiter = ':')
    void checkHintIsCorrect(String inputNumbers, String expected) {
        String originalNumbers = "379";
        int[] strikesAndBalls = baseballPlayground.getStrikesAndBalls(originalNumbers, inputNumbers);
        String actual = baseballPlayground.getHint(strikesAndBalls);
        assertThat(actual).isEqualTo(expected);
    }



}
