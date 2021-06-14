package one1_creational_patterns.builder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
public class Car {
    private int id;
    private String mark;
    private String model;
    private Date registration;
    private java.sql.Date dateProizvodstva;
    private int doorNumbers;
    private String color;
    private String engineType;
    private double engineVolume;

    private Car() {
    }

    public static CarBuilder newCarBuilder() {
        return new Car().new CarBuilder();
    }


    public class CarBuilder {
        private CarBuilder() {
        }

        public CarBuilder setId(int id) {
            Car.this.id = id;
            return this;
        }

        public CarBuilder setMark(String mark) {
            Car.this.mark = mark;
            return this;
        }

        public CarBuilder setModel(String model) {
            Car.this.model = model;
            return this;
        }

        public CarBuilder setRegistration(Date registration) {
            Car.this.registration = registration;
            return this;
        }

        public CarBuilder setDateProizvodstva(java.sql.Date dateProizvodstva) {
            Car.this.dateProizvodstva = dateProizvodstva;
            return this;
        }

        public CarBuilder setDoorNumbers(int doorNumbers) {
            Car.this.doorNumbers = doorNumbers;
            return this;

        }

        public Car build() {
            return Car.this;
        }
    }
}
