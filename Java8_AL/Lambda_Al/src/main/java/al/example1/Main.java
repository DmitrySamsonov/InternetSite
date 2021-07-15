package al.example1;

public class Main {
    public static void main(String[] args) {
        Operation operation1 = new OperationImplementation();
        System.out.println(operation1.getResult(2.0, 3.8));

        // old version - use internal anonymous class
        Operation operation = new Operation() {
            @Override
            public double getResult(double value1, double value2) {
                return value1 + value2;
            }
        };
        System.out.println(operation.getResult(2.0, 3.8));

        // Java 8; do some modifications:
        // 1
      /*  Operation operation2 = (double value1, double value2) {
                return value1 + value2;*/

        //  2.  add spec symbol ->
        Operation operation2 = (double value1, double value2) -> {
            return value1 + value2;
        };
        System.out.println("Lambda is working and get result " + operation2.getResult(2.0, 3.8));

        // 3. new modification
        // delete types

        Operation operation3 = (value1, value2) -> {
            return value1 + value2;
        };
        System.out.println("Lambda 3 is working and get result " + operation3.getResult(2.0, 3.8));


        // 4. modification.
        // delete return and {} at the same time
        Operation operation4 = (value1, value2) -> value1 + value2;
        System.out.println("Lambda 4 is working and get result " + operation4.getResult(2.0, 3.8));
    }
}