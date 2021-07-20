package baseball;

// 클래스가 너무 많다. -> 너무 적은 범위로 설계한거 아닌가
// 테스트할 때 객체이름 신경쓰자ㅇㅇ
// ExitStatus가 왜 멤버변수로 되어있나
// 지역변수랑 멤버변수의 차이점이 뭐라고 생각하는지 -> 제대로 쓰자ㅇㅇ
// 인텔리제이에서 지역변수 쓰면 밑줄이 왜 뜨는지 제대로 알아옵시다ㅇㅇ
public class PlayGame {
    private InputView inputView = new InputView();
    //private ExitStatus exitStatus = ExitStatus.REPLAY;

    public void play() {
        ExitStatus exitStatus;
        exitStatus = ExitStatus.REPLAY;
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
