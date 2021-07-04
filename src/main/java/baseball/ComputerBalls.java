package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputerBalls {
    private List<Ball> computerBalls;

    ComputerBalls(List<Integer> numbers) {
        this.computerBalls = setBalls(numbers);
    }

    private List<Ball> setBalls(List<Integer> numbersList) {
        List<Ball> ballsList = new ArrayList<>();
        for(int i=0; i < numbersList.size(); i++) {
            ballsList.add(new Ball(i + 1, numbersList.get(i)));
        }
        return ballsList;
    }

    public BallStatus getStatus(Ball userBall) {
        for (Ball computerBall: computerBalls) {
            BallStatus status = computerBall.compare(userBall);
            if (status != BallStatus.NOTHING) {
                return status;
            }
        }
        return BallStatus.NOTHING;
    }

    public PlayResult play(List<Integer> userInputs) {
        PlayResult playResult = new PlayResult();
        for (int i = 0; i < userInputs.size(); i++) {
            Ball ball = new Ball(i + 1, userInputs.get(i));
            playResult.setResult(getStatus(ball));
        }
        return playResult;
    }
}
