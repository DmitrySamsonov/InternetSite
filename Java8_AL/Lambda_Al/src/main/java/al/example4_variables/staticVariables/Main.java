package al.example4_variables.staticVariables;

public class Main {
    private static double value1 = 2.0, value2 = 3.33;
    public static void main(String[] args) {
        //Old version
        Operations operations = new Operations() {
            @Override
            public double getResult() {
                value1 = 1000;
                return value1+value2;
            }
        };
        System.out.println(operations.getResult());
        System.out.println(value1);
        System.out.println(value2);

        // Java 8
        Operations operations2 = () -> { value1 = 1000;
                return value1+value2;
            };

        System.out.println(operations2.getResult());
    }
}
