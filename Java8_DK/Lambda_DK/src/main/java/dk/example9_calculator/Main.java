package dk.example9_calculator;

public class Main {
    public static void main(String[] args) {
        System.out.println(getOperation('+').getResult(1, 5));
        System.out.println(getOperation('-').getResult(1, 5));
        System.out.println(getOperation('*').getResult(1, 5));
        System.out.println(getOperation('/').getResult(1, 5));

    }

    private static Operation getOperation(char symbol) {
        if (symbol == 43) {  //43 == +
            return (value1, value2) -> value1 + value2;
        } else if (symbol == '-') {
            return (val1, val2) -> val1 - val2;
        } else if (symbol == '/') {
            return (val1, val2) -> val1 / val2;
        } else if (symbol == '*') {
            return (val1, val2) -> val1 * val2;
        }
        return null;
    }
}

