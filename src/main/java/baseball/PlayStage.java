package baseball;

import java.util.ArrayList;
import java.util.List;

public class PlayStage {
    private ComputerBalls computerBalls;
    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();
    private List<Integer> userInputs = new ArrayList<>();
    private PlayResult playResult = new PlayResult();

    PlayStage() {
        RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();
        computerBalls = new ComputerBalls(randomNumbersGenerator.getNumbers());
    }

    public void play() {
        while(!playResult.isStrikeOut()) {
            userInputs = inputView.getInputsForUserBalls();
            playResult = computerBalls.play(userInputs);
            resultView.printHint(playResult);
        }
    }
}
