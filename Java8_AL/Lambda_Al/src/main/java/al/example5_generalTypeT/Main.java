package al.example5_generalTypeT;

public class Main {
    public static void main(String[] args) {

        // OLD
        Operations<Integer> additional1 = new Operations<Integer>() {
            @Override
            public Integer getResult(Integer value1, Integer value2) {
                return value1 + value2;
            }
        };
        System.out.println(additional1.getResult(55, 2));


        Operations<String> concatinatiol1 = new Operations<String>() {
            @Override
            public String getResult(String value1, String value2) {
                return value1 + value2;
            }
        };
        System.out.println(concatinatiol1.getResult("ghj00  ", "g65v"));
// JAVA 8
        Operations<Integer> add2 = (value1, value2) -> value1 + value2;
        Operations<String> conc2 = (value1, value2) -> value1 + value2;
        System.out.println(add2.getResult(54, 88));
        System.out.println(conc2.getResult("54", "88"));
    }
}
