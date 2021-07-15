package al.example4_variables.localVariables;

public class Main {


    public static void main(String[] args) {

        double value1 = 2.0, value2 = 3.33;
        value1 = 55.00;
        double value3 = value1 + value2;

        // Old version
        Operations operations = new Operations() {
            @Override
            public double getResult() {
              //  value1 = 1050;          // Compilation error! Can not edit variable in lambda
                return value3;
            }
        };
        System.out.println(operations.getResult());
        System.out.println(value1);
        System.out.println(value2);

        // Java 8

        Operations operations2 = () ->   value3;
         System.out.println(operations2.getResult());
    }


}
