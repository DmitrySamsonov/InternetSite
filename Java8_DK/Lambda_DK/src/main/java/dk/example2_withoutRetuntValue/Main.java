package dk.example2_withoutRetuntValue;

public class Main {

    public static void main(String[] args) {

        //    old version:

        Printer printer = new Printer() {
            @Override
            public void printMe(String s) {
                System.out.println(s);
            }

        };
        printer.printMe("new Printer");

        // Java8:
        Printer printerJava8 = s -> System.out.println(s);
        printerJava8.printMe("printerJava8");


    }
}