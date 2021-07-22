package example2_creatingStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //Create using Arrays.stream()
        Stream<String> objectStream = Arrays.stream(new String[]{"a", "b", "c"});
        objectStream.forEach(System.out::println);

        IntStream intStream = Arrays.stream(new int[]{1, 2, 3, 4});
        intStream.forEach(System.out::println);

        LongStream longStream = Arrays.stream(new long[]{1L, 2L, 3L, 4L});
        longStream.forEach(System.out::println);

        DoubleStream doubleStream = Arrays.stream(new double[]{1, 2, 3, 4});
        doubleStream.forEach(System.out::println);

        //Create using Stream.of()
        System.out.println("Create using Stream.of()");

        Stream<String> objectStream2 = Stream.of("a", "b", "c");
        objectStream2.forEach(System.out::println);

        IntStream intStream2 = IntStream.of(4, 5, 6, 7);
        intStream2.forEach(System.out::println);

        LongStream longStream2 = LongStream.of(1L, 2L, 3L, 4L);
        longStream2.forEach(System.out::println);

        DoubleStream doubleStream2 = DoubleStream.of(1, 2, 3, 4);
        doubleStream2.forEach(System.out::println);


        //Create Stream from collection using Collettion.stream()
        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings,"asdasd","asda","asdasdawerweq","asdasdsarnfgsbdv");
        strings.stream().forEach(System.out::println);

    }
}
