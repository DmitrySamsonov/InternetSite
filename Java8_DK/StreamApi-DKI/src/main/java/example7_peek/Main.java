package example7_peek;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

//        peek() использует каждый элемент стрима не изменяя исходники
        Stream.of("a", "b", "c", "1", "2")
                .peek(s -> System.out.print(s =  s + "! "))
                .forEach((s -> System.out.print(s + " ")));

    }
}
