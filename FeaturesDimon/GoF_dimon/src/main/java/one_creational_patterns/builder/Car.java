package one_creational_patterns.builder;

import lombok.ToString;

import java.util.Date;

@ToString
public class Car {
    private int id;
    private String mark;
    private String model;
    private Date dateRegistration;
    private java.sql.Date dateProizvod;
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

        public CarBuilder setDateRegistration(Date dateRegistration) {
            Car.this.dateRegistration = dateRegistration;
            return this;
        }

        public CarBuilder setDateProizvod(java.sql.Date dateProizvod) {
            Car.this.dateProizvod = dateProizvod;
            return this;
        }

        public CarBuilder setdoorNumbers(int doorNumbers) {
            Car.this.doorNumbers = doorNumbers;
            return this;
        }
        public CarBuilder setcolor(String color) {
            Car.this.color = color;
            return this;
        }

        public Car build() {
            return Car.this;
        }
    }
}
