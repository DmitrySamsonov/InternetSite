package example9_Sorted;


import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream.of(6, 80, 5, 6, 85, 55, 7)
                .sorted()
                .forEach((s -> System.out.print(s + " ")));

        System.out.println("");

        Stream.of(6, 80, 5, 6, 85, 55, 7)
                .sorted((o1, o2) -> Integer.compare(o2,o1))
                .forEach((s -> System.out.print(s + " ")));

        System.out.println("");

        Stream.of(new Film("Rembo",9.0 ),
                new Film("2012",9.5 ),
                new Film("Телохранитель жены киллера",7.68 ),
                new Film("Чёрная Вдова",9.1 ))
                .sorted(Comparator.comparingInt(value -> value.getTitle().length()))
                        .forEach((s -> System.out.println(s + " ")));



    }
}
