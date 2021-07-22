package dk.example1;

public class Main {
    public static void main(String[] args) {
        Operation operation1 = new OperationImpl();
        System.out.println(operation1.getResult(2.0, 3.0));

        //old version - - use internal anonymous class
        Operation operation = new Operation() {
            @Override
            public double getResult(double value1, double value2) {
                return value1 + value2;
            }

        };
        System.out.println(operation.getResult(2.0, 3.0));

        //Java8
        //do some modifications1:
//        Operation operationJava8 = (double value1, double value2) {
//                return value1 + value2;
//        }

        //do some modifications2:
        //add spec symbol "->"
        Operation operationJava8 = (double value1, double value2) -> {
            return value1 + value2;
        };

        System.out.println("test that it work " + operationJava8.getResult(2.0, 3.0));

        //do some modifications3:
        // delete types
        Operation operationJavaMod3 = (value1, value2) -> {
            return value1 + value2;
        };

        System.out.println("test that it work 3 delete types " + operationJavaMod3.getResult(2.0, 3.0));

        //do some modifications4:
        // delete return AND { } at the same time
        Operation operationJavaMod4 = (value1, value2) ->  value1 + value2;


        System.out.println("test that it work 4 at the same time " + operationJavaMod4.getResult(2.0, 3.0));

    }
}
