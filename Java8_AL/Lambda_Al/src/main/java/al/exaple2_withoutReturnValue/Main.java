package al.exaple2_withoutReturnValue;

public class Main {
    public static void main(String[] args) {

        // Old version:
        Printer printer = new Printer() {
            @Override
            public void printMe(String s) {
                System.out.println(s);
            }
        };
        printer.printMe("hyjjh ddfggh drgtht5t6");

        // Java 8 :
        Printer printer1 = s -> System.out.println(s);

        printer1.printMe("Go GO JAVA!!!!");



    }

}
