package dk.example5_generalTypeT;

public class Main {

    public static void main(String[] args) {

        Operation<Integer> additional1 = new Operation<Integer>() {
            @Override
            public Integer getResult(Integer value1, Integer value2) {
                return value1 + value2;
            }
        };
        System.out.println(additional1.getResult(2, 3));

        Operation<String> concatenation1 = new Operation<String>() {
            @Override
            public String getResult(String value1, String value2) {
                return value1 + value2;
            }
        };
        System.out.println(concatenation1.getResult("2", "3"));
        System.out.println(' ');


//    Java8
        Operation<Integer> additionalJava8 = (Integer value1, Integer value2) -> value1 + value2;
        System.out.println(additionalJava8.getResult(2, 3));


        Operation<String> concatenationJava8 = (String value1, String value2) -> value1 + value2;
        System.out.println(concatenationJava8.getResult("2", "3"));
        System.out.println(' ');

//    Java8
        Operation<Integer> additionalJava8a = (value1, value2) -> value1 + value2;
        System.out.println(additionalJava8a.getResult(6, 7));


        Operation<String> concatenationJava8a = (value1, value2) -> value1 + value2;
        System.out.println(concatenationJava8a.getResult("6", "7"));
        System.out.println(' ');

    }
}
