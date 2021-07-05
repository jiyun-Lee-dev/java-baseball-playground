package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumbersGeneratorTest {
    public ValidationNumbers validationNumbers;
    public RandomNumbersGenerator randomNumbersGenerator;

    @BeforeEach
    void setUp() {
        validationNumbers = new ValidationNumbers();
        randomNumbersGenerator = new RandomNumbersGenerator();
    }

    @Test
    void 생성된_숫자가_1부터_9까지의_범위인지_확인() {
        assertThat(validationNumbers.validateNumber(randomNumbersGenerator.generateNumber())).isTrue();
    }

    @Test
    void 생성된_숫자들이_3자리수인지_확인() {
        assertThat(validationNumbers.validateLength(randomNumbersGenerator.getNumbersLength())).isTrue();
    }

    @Test
    void 생성된_숫자들이_중복된_숫자가_없는지_확인() {
        assertThat(validationNumbers.validateDuplicate(randomNumbersGenerator.getNumbers())).isTrue();
    }
}
