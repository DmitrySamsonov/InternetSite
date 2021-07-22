package example4_limit;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // limit(n) - промежуточный метод, который в потоке данных ограничивает первых "n" элементов
        Stream<String> objectStream = Stream.of("a", "b", "c", "1", "2");
        objectStream.limit(2).forEach(System.out::println);

//        objectStream.skip(2).forEach(System.out::println);


    }
}
