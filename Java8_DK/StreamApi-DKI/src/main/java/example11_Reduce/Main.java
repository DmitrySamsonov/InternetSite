package example11_Reduce;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        long reduce = IntStream.rangeClosed(1, 34).reduce(1, (left, right) -> left * right);
        System.out.println(reduce);

    }
}
