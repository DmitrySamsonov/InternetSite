package example5_filter;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //1
        Stream<String> objectStream = Stream.of("a", "b", "c", "1", "2");

        objectStream.filter(s -> s.equals("b")).forEach(System.out::println);

        //var 2.0
        System.out.println("var 2");

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(String.valueOf(i));
        }

        arrayList.stream().filter(s -> Integer.parseInt(s) > 5).forEach(System.out::println);
        System.out.println("!");
//        var 2.1  = var 2.0
//        arrayList.stream().filter(s -> {
//            int number = Integer.parseInt(s);
//            if (number > 5) {
//                return true;
//            } else {
//                return false;
//            }
//        }).forEach(System.out::println);
            arrayList.removeIf(s -> Integer.parseInt(s) > 5);
        System.out.println("!!");
    }
}
