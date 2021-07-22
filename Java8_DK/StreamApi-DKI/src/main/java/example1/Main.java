package example1;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        //old
        int[] numbers = {-2, -1, 0, 1, 2};
        int i = 0;
        for (; i < numbers.length; ) {
            if (numbers[i] < 0) {
                System.out.println(numbers[i]);
            }
            i++;
        }
        int j = 0;
        while (j < numbers.length) {
            if (numbers[j] < 0) {
                System.out.println(numbers[j]);
            }
            j++;
        }
        for (int element : numbers) {
            if (element < 0) {
                System.out.println(element);
            }
        }


        //Java8
        System.out.println("Java8");
        //жизненный цикл потока данных:
        //1. формирование
        //2. выполнение промежуточных операций
        //3. выполнение терминальных операций, после которых уже можно получить результат

        //метод of() - формирует поток данных
        //метод filter() - выполняет промежуточные операции над потоком данных
        //метод forEach() - выполняет терминальные операции над потоком данных
        IntStream.of(-2, -1, 0, 1, 2).filter(value -> value < 0).filter(value -> value < -1).forEach(System.out::println);
//        IntStream.of(numbers).filter(value -> value < 0).forEach(System.out::println);
//        IntStream.of(numbers).forEach(System.out::println);


    }
}
