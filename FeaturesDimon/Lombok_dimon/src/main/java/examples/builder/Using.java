package examples.builder;

import java.sql.Date;

public class Using {

    public static void main(String[] args) {
        Car car = Car.builder().model("a6").mark("audi").color("red").engineVolume(7000).dateRegistration(new Date((long) 1623030039*1000))                .build();
        System.out.println(car);
    }
}
