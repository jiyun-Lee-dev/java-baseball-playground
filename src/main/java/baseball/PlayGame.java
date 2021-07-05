package baseball;

public class PlayGame {
    private InputView inputView = new InputView();
    private ExitStatus exitStatus = ExitStatus.REPLAY;

    public void play() {
        while(ExitStatus.isNotExit(exitStatus)) {
            PlayStage playStage = new PlayStage();
            playStage.play();
            exitStatus = getExitStatus(inputView.getInputForSystemExit());
        }
    }

    private ExitStatus getExitStatus(int input) {
        if (input == 1) {
            return ExitStatus.REPLAY;
        }
        return ExitStatus.EXIT;
    }

    public static void main(String[] args) {
        PlayGame playGame = new PlayGame();
        playGame.play();
    }
}
