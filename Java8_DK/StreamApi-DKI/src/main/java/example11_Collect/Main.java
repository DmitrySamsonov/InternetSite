package example11_Collect;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = Stream.of(6, 80, 5, 6, 85, 55, 7)
                .collect(Collectors.toList());
        list.stream().forEach((s -> System.out.print(s + " ")));
        System.out.println(" ");
        System.out.println(list);


        Set<Integer> collect = Stream.of(6, 80, 5, 6, 6, 80, 5, 6, 85, 55, 7).collect(Collectors.toSet());
        collect.stream().forEach((s -> System.out.print(s + " ")));

        System.out.println(" ");

        Set<Film> filmSet = Stream.of(new Film("Rembo", 9.0),
                new Film("2012", 9.5),
                new Film("Телохранитель жены киллера", 7.68),
                new Film("Телохранитель жены киллера", 7.68),
                new Film("Телохранитель жены киллера", 10.68),
                new Film("Чёрная Вдова", 9.1)).collect(Collectors.toSet());

    filmSet.stream().forEach((s -> System.out.println(s + " ")));
    }
}
