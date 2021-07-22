package dk.example4_variables.local_variables;

public class Main {
    public static void main(String[] args) {

        double a = 1.0;
        double b = 1.0;
        final double value1 = a + b, value2 = 3.0;
        Operation operation = new Operation() {
            @Override
            public double getResult() {
//                value1 = 100;    // compilation error!! cannot edit variable in lambda
                return value1 + value2;
            }
        };

        System.out.println(operation.getResult());
        System.out.println(value1);
        System.out.println(value2);

        double value = operation.getResult();

//        Java8:
        Operation operationJava8 = () -> {
//                value1 = 100;    // compilation error!! cannot edit variable in lambda
            return value1 + value2;
        };

        System.out.println(operationJava8.getResult());
        System.out.println(value1);
        System.out.println(value2);


    }
}
