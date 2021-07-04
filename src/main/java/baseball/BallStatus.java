package baseball;

public enum BallStatus {
    STRIKE, NOTHING, BALL;

    public static boolean isBall(BallStatus status) {
        return status == BALL;
    }

    public static boolean isStrike(BallStatus status) {
        return status == STRIKE;
    }
}
