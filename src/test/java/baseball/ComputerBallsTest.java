package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;

public class ComputerBallsTest {
    public ComputerBalls computerBalls;

    @BeforeEach
    void setUp() {
        computerBalls = new ComputerBalls(Arrays.asList(1, 2, 3));
    }

    @Test
    void 컴퓨터볼3개랑_유저볼1개랑_비교했을때_제대로_볼이라고_판단하는지_확인() {
        assertThat(computerBalls.getStatus(new Ball(2, 1))).isEqualTo(BallStatus.BALL);
        assertThat(computerBalls.getStatus(new Ball(2, 3))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 컴퓨터볼3개랑_유저볼1개랑_비교했을때_제대로_스트라이크라고_판단하는지_확인() {
        assertThat(computerBalls.getStatus(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
        assertThat(computerBalls.getStatus(new Ball(2, 2))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 컴퓨터볼3개랑_유저볼1개랑_비교했을때_제대로_낫싱이라고_판단하는지_확인() {
        assertThat(computerBalls.getStatus(new Ball(2, 5))).isEqualTo(BallStatus.NOTHING);
        assertThat(computerBalls.getStatus(new Ball(1, 6))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void 컴퓨터볼3개랑_유저볼3개랑_비교했을때_1볼인_경우_확인() {
        PlayResult playResult = computerBalls.play(Arrays.asList(4, 5, 1));
        assertThat(playResult.getBall()).isEqualTo(1);
        assertThat(playResult.getStrike()).isEqualTo(0);
    }

    @Test
    void 컴퓨터볼3개랑_유저볼3개랑_비교했을때_1스트라이크인_경우_확인() {
        PlayResult playResult = computerBalls.play(Arrays.asList(1, 6, 5));
        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(1);
    }

    @Test
    void 컴퓨터볼3개랑_유저볼3개랑_비교했을때_1볼_1스트라이크인_경우_확인() {
        PlayResult playResult = computerBalls.play(Arrays.asList(1, 3, 5));
        assertThat(playResult.getBall()).isEqualTo(1);
        assertThat(playResult.getStrike()).isEqualTo(1);
    }

    @Test
    void 컴퓨터볼3개랑_유저볼3개랑_비교했을때_3스트라이크인_경우_확인() {
        PlayResult playResult = computerBalls.play(Arrays.asList(1, 2, 3));
        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(3);
    }

    @Test
    void 컴퓨터볼3개랑_유저볼3개랑_비교했을때_낫싱인_경우_확인() {
        PlayResult playResult = computerBalls.play(Arrays.asList(4, 5, 6));
        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(0);
    }
}
