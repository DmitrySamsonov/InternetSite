package dk.example4_variables.static_variables;

public class Main {

    private static double value1 = 2.0, value2 = 3.0;

    public static void main(String[] args) {

        Operation operation = new Operation() {
            @Override
            public double getResult() {
                value1 = 100;
                return value1 + value2;
            }
        };

        System.out.println(operation.getResult());
        System.out.println(value1);
        System.out.println(value2);


//        Java8:
        Operation operationJava8 = () -> {
            value1 = 100;
            return value1 + value2;
        };
        System.out.println(operationJava8.getResult());
        System.out.println(value1);
        System.out.println(value2);



    }
}
