package al.example3_moreThanOneLineOfCode;

public class Main {
    public static void main(String[] args) {

        // Old version
        Factorial factorial = new Factorial() {
            @Override
            public int calculateFactorial(int value) {
                int result = 1;
                for (int i = 1; i <= value; i++) {
                    result = result * i;   // result *= i;
                }
                return result;
            }
        };
        int result1 = factorial.calculateFactorial(4);
        System.out.println("factorial of 4: 1 * 2 * 3 * 4 = " + result1);


        // Java 8

        Factorial factorial2 = value -> {
            int result = 1;
            for (int i = 1; i <= value; i++) {
                result = result * i;   // result *= i;
            }
            return result;
        };

        int result2 = factorial.calculateFactorial(4);
        System.out.println("factorial 2 lambda of 4: 1 * 2 * 3 * 4 = " + result2);


    }
}
