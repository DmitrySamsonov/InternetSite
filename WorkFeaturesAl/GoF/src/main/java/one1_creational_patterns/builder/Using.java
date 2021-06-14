package one1_creational_patterns.builder;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Using {
    public static void main(String[] args) {
        Car audi = getCar();
        System.out.println(audi);

    }

    private static Car getCar() {

        return Car.newCarBuilder()
                .setId(125)
                .setMark("Audi")
                .setDoorNumbers(5)
                .setRegistration(new Date(2122555559))
                .build();


    }
}