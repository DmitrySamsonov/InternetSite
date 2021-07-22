package dk.example3_moreThanOneLineOfCode;

public class Main {
    public static void main(String[] args) {
//      old
        Factorial factorial = new Factorial() {
            @Override
            public int calculateFactorial(int value) {
                int result = 1;

                for (int i = 1; i <= value; i++) {
                    result = result * i;    // <==>   result *= i;
                }
                return result;
            }
        };
        int result1 = factorial.calculateFactorial(4);
        System.out.println("factorial of 4 : 1*2*3*4 = " + result1);

//        Java8:

        Factorial factorialJava8 = value -> {
            int result = 1;
            for (int i = 1; i <= value; i++) {
                result = result * i;    // <==>   result *= i;
            }
            return result;
        };

        int resultJava8 = factorialJava8.calculateFactorial(4);
        System.out.println("factorial Java8 of 4 : 1*2*3*4 = " + resultJava8);

    }
}
