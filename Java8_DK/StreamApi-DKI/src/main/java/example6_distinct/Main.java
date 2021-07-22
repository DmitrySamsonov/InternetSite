package example6_distinct;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream.of("a", "b", "b", "b", "b", "b", "b", "c", "1", "1", "1", "1", "1", "2")
                .distinct()
                .forEach(s -> System.out.print(s + " "));


    }
}
