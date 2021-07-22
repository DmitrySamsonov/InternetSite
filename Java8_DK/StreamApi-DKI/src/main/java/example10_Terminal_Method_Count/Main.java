package example10_Terminal_Method_Count;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        long count = Stream.of(6, 80, 5, 6, 85, 55, 7)
                .filter(integer -> integer>=50)
                .count();

        System.out.println(count);


    }
}
