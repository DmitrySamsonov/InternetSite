package example8_Map;

import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {

//      map() - выполняет действия с каждым объектом, меняет исходный стрим
//        v 1
        Stream.of("a", "b", "c", "1", "2")
                .map(s -> s += "1")
                .forEach((s -> System.out.print(s + " ")));

        System.out.println(" ");
//        v 2
        Stream.of(new Film("rembo",9.0 ),
                new Film("2012",9.5 ))
                .map(Film::getTitle)
                .forEach((s -> System.out.print(s + " ")));


    }
}
