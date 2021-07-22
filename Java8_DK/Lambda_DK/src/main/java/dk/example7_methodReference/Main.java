package dk.example7_methodReference;

import java.util.function.Consumer;

//ссылка на метод
public class Main {
    public static void main(String[] args) {

        //old
        Consumer<String> printer0 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };


//        work variant
        Consumer<String> printer1 = text -> System.out.println(text);
        printer1.accept("work variant");

//        work v2.0
//            - use method reference

        Consumer<String> printerReference = System.out::println;
        printerReference.accept("use method reference");

//        work v3.0

        Consumer<String> printerReference1 = Main::printMe;
        printerReference1.accept("printerReference1");


    }

    static void printMe(String text) {
        System.out.println(text);
    }
}
