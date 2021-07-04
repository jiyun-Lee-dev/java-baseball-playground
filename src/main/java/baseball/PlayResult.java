package baseball;

public class PlayResult {
    private int strike;
    private int ball;

    PlayResult() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getBall() {
        return this.ball;
    }

    public int geStrike() {
        return this.strike;
    }

    public void setResult(BallStatus status) {
        if (BallStatus.isBall(status)) {
            this.ball += 1;
        }
        if (BallStatus.isStrike(status)) {
            this.strike += 1;
        }
    }

    public boolean isStrikeOut() {
        return this.strike == 3;
    }
}
