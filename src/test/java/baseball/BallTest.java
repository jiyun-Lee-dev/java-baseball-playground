package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    public Ball computerBall;

    @BeforeEach
    void setUp() {
        computerBall = new Ball(1, 3);
    }

    @Test
    void 제대로_볼이라고_판단하는지_확인() {
        BallStatus actual = computerBall.compare(new Ball(2, 3));
        assertThat(actual).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 제대로_스트라이크라고_판단하는지_확인() {
        BallStatus actual = computerBall.compare(new Ball(1, 3));
        assertThat(actual).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 제대로_낫싱이라고_판단하는지_확인() {
        BallStatus actual = computerBall.compare(new Ball(1, 5));
        assertThat(actual).isEqualTo(BallStatus.NOTHING);
    }
}
