package one_creational_patterns.builder;

import java.util.Date;

public class Using {

    public static void main(String[] args) {

        Car car = getAudi();

        System.out.println(car);

    }

    private static Car getAudi() {
        return Car.newCarBuilder()
                .setId(1)
                .setMark("audi")
                .setModel("A6")
                .setDateRegistration(new Date(1212156720))
                .setEngineType("V8")
                .setEngineVolume(2.7)
                .build();
    }
}
