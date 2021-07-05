package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationNumbersTest {
    private ValidationNumbers validationNumbers;

    @BeforeEach
    void setUp() {
        validationNumbers = new ValidationNumbers();
    }

    @Test
    void 세자리_숫자가_맞는지_확인() {
        assertThat(validationNumbers.validateLength(3)).isTrue();
        assertThat(validationNumbers.validateLength(2)).isFalse();
    }

    @Test
    void 숫자가_1부터_9까지의_숫자인지_확인() {
        assertThat(validationNumbers.validateNumber(1)).isTrue();
        assertThat(validationNumbers.validateNumber(9)).isTrue();
        assertThat(validationNumbers.validateNumber(10)).isFalse();
        assertThat(validationNumbers.validateNumber(0)).isFalse();
    }

    @Test
    void 중복된_숫자가_있는지_확인() {
        assertThat(validationNumbers.validateDuplicate(Arrays.asList(1, 2, 3))).isTrue();
        assertThat(validationNumbers.validateDuplicate(Arrays.asList(4, 5, 6))).isTrue();
        assertThat(validationNumbers.validateDuplicate(Arrays.asList(1, 1, 2))).isFalse();
        assertThat(validationNumbers.validateDuplicate(Arrays.asList(4, 4, 4))).isFalse();
    }
}
