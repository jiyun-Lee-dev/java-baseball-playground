package baseball;

import java.util.Objects;

public class Ball {
    private int position;
    private int number;

    Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public BallStatus compare(Ball ball) {
        if (this.matchAll(ball)) {
            return BallStatus.STRIKE;
        }
        if (this.matchNumber(ball)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchAll(Ball ball) {
        return this.number == ball.number && this.position == ball.position;
    }

    private boolean matchNumber(Ball ball) {
        return this.number == ball.number;
    }
}
