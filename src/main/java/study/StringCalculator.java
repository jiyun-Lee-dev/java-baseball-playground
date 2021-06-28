package study;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.Character.isDigit;

public class StringCalculator {

    StringCalculator(){
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public boolean isNotEmpty(String input) {
        if (input == null || input.isEmpty() ) {
            return false;
        }
        return true;
    }

    public String[] splitBlank(String input) {
        return input.split(" ");
    }

    public boolean isRightExpression(String input) {
        String[] tempValues = this.splitBlank(input);
        String replaceResult = input.replaceAll(" ", "");
        replaceResult = replaceResult.replaceAll("[+\\-*/]", "");
        replaceResult = replaceResult.replaceAll("[0-9]", "");

        if (tempValues.length < 2) return false;
        if (!isDigit(input.charAt(0))) return false;
        if (tempValues[tempValues.length - 1].matches("[+\\-*/]")) return false;
        if (replaceResult.length() > 0) return false;

        return true;
    }

    public Integer stringToInt(String value) {
        return Integer.parseInt(value);
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public int calculate(int left, String operator, int right) {
        int result = 0;
        if (operator.equals("+")) {
            result = this.sum(left, right);
        }
        if (operator.equals("-")) {
            result = this.subtract(left, right);
        }
        if (operator.equals("*")) {
            result = this.multiply(left, right);
        }
        if (operator.equals("/")) {
            result = this.divide(left, right);
        }
        return result;
    }

    public int getResult(String[] values) {
        int result = 0;
        int left = this.stringToInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            String operator = values[i];
            int right = this.stringToInt(values[i + 1]);
            result = calculate(left, operator, right);
            left = result;
        }
        return result;
    }

    public String runStringCalculator() {
        String input = this.getInput();
        if (this.isNotEmpty(input) && this.isRightExpression(input)) {
            return "" + getResult(this.splitBlank(input));
        }
        return "계산식 오류";
    }

}
