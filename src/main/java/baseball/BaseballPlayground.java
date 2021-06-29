package baseball;

import java.util.*;

public class BaseballPlayground {
    public String randomNumbers;
    public int[] strikesAndBalls;

    BaseballPlayground() {
        this.randomNumbers = this.getRandomNumbers();
        this.strikesAndBalls = new int[2];
    }

    public String getRandomNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while(numbers.size() < 3) {
            numbers.add((int)((Math.random() * 8) + 1 ));
        }
        return this.changeSetToString(numbers);
    }

    public String changeSetToString(Set<Integer> set) {
        Iterator<Integer> iter = set.iterator();
        String string = "";
        int index = 0;

        while(iter.hasNext()) {
            string += iter.next();
        }

        return string;
    }

    public String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public boolean isInputValid(String input) {
        int[] inputNumbers = this.changeStringToIntArray(input);
        if (inputNumbers.length > 3) return false;
        if (this.hasDuplicateNumber(input)) return false;
        if (this.hasZero(input)) return false;
        return true;
    }

    public int[] changeStringToIntArray(String string) {
        int[] array = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
            array[i] = string.charAt(i) - '0';
        }
        return array;
    }

    public boolean hasDuplicateNumber(String input) {
        String[] values = input.split("");
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(values));
        if (hashSet.size() == input.length()) return false;
        return true;
    }

    public boolean hasZero(String input) {
        return input.contains("0");
    }

    public int[] getStrikesAndBalls(String original, String input) {
        int[] strikesAndBalls = new int[2];
        for (int i = 0; i < input.length(); i++) {
            int index = original.indexOf(input.charAt(i));
            if (index > -1 && index == i) {
                strikesAndBalls[0]++;
                continue;
            }
            if (index > -1 && index != i) {
                strikesAndBalls[1]++;
                continue;
            }
        }
        return strikesAndBalls;
    }

    public String getHint(int[] strikesAndBalls) {
        int strikes = strikesAndBalls[0];
        int balls = strikesAndBalls[1];
        if (strikes > 0 && balls > 0) {
            return balls + "볼 " + strikes + "스트라이크";
        }
        if (strikes > 0 && balls == 0) {
            return strikes + "스트라이크";
        }
        if (strikes == 0 && balls > 0) {
            return balls + "볼";
        }
        return "낫싱";
    }

    public boolean getInputAndStopGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.equals("1");
    }

    public boolean play() {
        while(this.strikesAndBalls[0] < 3) {
            String input = this.getInput();
            if (!this.isInputValid(input)) {
                return false;
            }
            int[] strikesAndBalls = this.getStrikesAndBalls(this.randomNumbers, input);
            System.out.println(this.getHint(strikesAndBalls));
        }
        return true;
    }

    public static void main(String[] args) {
        boolean exitStatus = false;
        while(!exitStatus) {
            BaseballPlayground baseballPlayground = new BaseballPlayground();
            if (!baseballPlayground.play()) {
                System.out.println("입력값이 유효하지 않습니다. 게임 종료");
                break;
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            exitStatus = baseballPlayground.getInputAndStopGame();
        }
    }


}
