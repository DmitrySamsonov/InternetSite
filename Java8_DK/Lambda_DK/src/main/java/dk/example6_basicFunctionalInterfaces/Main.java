package dk.example6_basicFunctionalInterfaces;

import java.util.Scanner;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {


//        old version
//        Predicate - выполняется проверка условия
        // boolean test(T t);
        Predicate<Integer> isZero = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer == 0) {
                    return true;
                }
                return false;
            }
        };

        System.out.println(isZero.test(12));


//        Java8
//        Predicate - выполняется проверка условия

        Predicate<Integer> isZeroJava8 = (integer) -> integer == 0;
        System.out.println(isZeroJava8.test(12));


//          old version
//        Consumer - выполняет действие над обьектом типа <T>, ничего не возвращает
        // void accept(T t);

        Consumer<String> printer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Consumer<String> printer2 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("!" + s + "!");
            }
        };

        //Java8:
        Consumer<String> printer3 = s -> System.out.println("#" + s + "#");
        printer1.andThen(printer2).andThen(printer3).accept("bbb");


//        Function
//        переход от объекта <T> k <R>
//        R apply(T t);

        Function<Integer, Double> function = (integer) -> Double.valueOf(integer);
        System.out.println(function.apply(5));

//        Supplier
//        Возвращает объект типа <T> ничего на вход
//        T get();

        Supplier<Integer> supplier = () -> {
            Scanner scanner = new Scanner(System.in);
            int number1 = scanner.nextInt();
            scanner.nextLine();
            String operation = scanner.nextLine();
            int number2 = scanner.nextInt();
            if ("+".equals(operation)) {
                return number1 + number2;

            } else if ("-".equals(operation)) {
                return number1 - number2;

            }
            return null;
        };
        System.out.println(supplier.get());


//        UnaryOperator
//        Выполняет операции над объектом T


        UnaryOperator<Double> unaryOperator = (aDouble) -> Math.sqrt(aDouble);


        System.out.println(unaryOperator.apply(144.0));


        UnaryOperator<Double> asda = aDouble -> aDouble + 1000;
        System.out.println(asda.apply(3.0));


//        BinaryOperator
//        Выполняет операции над объектом T и R

        BinaryOperator<Double> binaryOperator = (aDouble, aDouble2) -> Math.pow(aDouble,aDouble2);
        System.out.println(binaryOperator.apply(2.0,15153.0));

    }
}




