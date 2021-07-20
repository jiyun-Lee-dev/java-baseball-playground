package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 클래스 이름과 메소드 이름이 혼동됨. 너무 비슷함.
public class ValidationNumbers {
    public boolean validateLength(int length) {
        return length == 3;
    }

    public boolean validateNumber(int ballNumber) {
        return (ballNumber > 0 && ballNumber < 10);
    }

    public boolean validateDuplicate(List<Integer> ballNumbers) {
        List<Integer> distinctNumbers =  ballNumbers.stream()
                                                    .distinct()
                                                    .collect(Collectors.toList());
        return ballNumbers.size() == distinctNumbers.size();
    }

    private boolean validateNumbers(List<Integer> ballNumbers) {
        boolean fail = ballNumbers.stream()
                            .anyMatch(ballNumber -> !validateNumber(ballNumber));
        //                .anyMatch(ballNumber -> ballNumber <= 0 || ballNumber >= 10);
        if (fail) return false;
        return true;
    }

    public boolean validate(List<Integer> splitNumbers) {
        return validateDuplicate(splitNumbers) && validateLength(splitNumbers.size()) && validateNumbers(splitNumbers);
    }
}
