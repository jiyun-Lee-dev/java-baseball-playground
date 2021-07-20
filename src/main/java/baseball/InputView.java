package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    private ValidationNumbers validationNumbers = new ValidationNumbers();
    private int inputNumbers = 0;

    public List<Integer> getInputsForUserBalls() {
        do {
            System.out.print("숫자를 입력해주세요: ");
            inputNumbers = scanner.nextInt();
        } while (!validationNumbers.validate(splitNumbers(inputNumbers)));

        return splitNumbers(inputNumbers);
    }

    public int getInputForSystemExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = scanner.nextInt();
        return input;
    }

    private List<Integer> splitNumbers(int inputNumber) {
        List<Integer> split = new ArrayList<>();
        if (isNotTripleDigit(inputNumber)) return split;
        split.add(inputNumber / 100);
        split.add((inputNumber % 100) / 10);
        split.add((inputNumber % 100) % 10);
        return split;
    }

    private boolean isNotTripleDigit(int number) {
        return number < 100 || number > 999;
    }
}
