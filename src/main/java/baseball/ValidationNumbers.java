package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidationNumbers {
    public boolean validateLength(int length) {
        return length == 3;
    }

    public boolean validateNumber(int ballNumber) {
        return (ballNumber > 0 && ballNumber < 10);
    }

    public boolean validateZero(List<Integer> ballNumbers) {
        List<Integer> distinctNumbers =  ballNumbers.stream()
                                                    .distinct()
                                                    .collect(Collectors.toList());
        return ballNumbers.size() == distinctNumbers.size();
    }
}
