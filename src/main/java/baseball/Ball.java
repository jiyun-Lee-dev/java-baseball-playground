package baseball;

import java.util.Objects;

public class Ball {
    private int position;
    private int number;

    Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    // equals 오버라이딩 무서움 -> 클래스를 상속받는 얘가 있고 별도의 필드가 추가됐음 그러고 나서 원래 클래스랑 상속한 클래스 객체랑 비교했을 때
    // 특정 필드값만 비교하다 보니까 정확한 비교 결과값이 나오지 않을 수도 있다.
    // 그래서 equals 오버라이딩을 하는거다. 이펙티브 자바 읽어라 - 이수쌤
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
