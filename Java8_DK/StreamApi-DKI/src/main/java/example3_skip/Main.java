package example3_skip;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] peremennaja) {

        // skip(n) - промежуточный метод, который в потоке данных пропускает первых "n" элементов
        Stream<String> objectStream = Stream.of("a", "b", "c", "1", "2");
        int n = 4;
        objectStream.skip(n).forEach(System.out::println);







    }

}
