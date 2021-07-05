package baseball;

public class ResultView {
    public void printHint(PlayResult playResult) {
        if (playResult.isStrikeOut()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        if (playResult.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        if (playResult.getBall() > 0) {
            System.out.print(playResult.getBall() + "볼 ");
        }
        if (playResult.getStrike() > 0) {
            System.out.print(playResult.getStrike() + "스트라이크");
        }
        System.out.println();
    }
}
