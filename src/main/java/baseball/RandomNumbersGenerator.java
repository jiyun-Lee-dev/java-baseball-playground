package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumbersGenerator {
    private List<Integer> randomNumbers;

    RandomNumbersGenerator() {
        this.randomNumbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        Set<Integer> set_numbers = new HashSet<>();
        List<Integer> list_numbers;
        while(set_numbers.size() < 3) {
            set_numbers.add((int)((Math.random() * 8) + 1 ));
        }
        list_numbers = new ArrayList<>(set_numbers);
        return list_numbers;
    }

    public int generateNumber() {
        return (int)((Math.random() * 8) + 1 );
    }

    public int getNumbersLength() {
        return this.randomNumbers.size();
    }

    public List<Integer> getNumbers() {
        return this.randomNumbers;
    }
}
