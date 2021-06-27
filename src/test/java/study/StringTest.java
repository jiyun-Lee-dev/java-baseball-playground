package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] parts = "1,2".split(",");
        assertThat(parts).contains("1", "2");

        parts = "1".split(",");
        assertThat(parts).containsExactly("1");
    }

    @Test
    void substring() {
        String remains = "1,2".substring(0,3);
        assertThat(remains).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 사용 시 위치 값이 범위를 넘어가면 에러 발생 확인")
    void charAt_exception() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
