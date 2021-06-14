package one_creational_patterns.builder;

import lombok.ToString;

import java.util.Date;

@ToString
public class Car {

    private int id;
    private String mark;
    private String model;
    private Date dateRegistration;
    private java.sql.Date dateManufactured;
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

        CarBuilder setMark(String mark) {
            Car.this.mark = mark;
            return this;
        }

        public CarBuilder setModel(String model) {
            Car.this.model = model;
            return this;
        }

        public CarBuilder setDateRegistration(Date dateRegistration) {
            Car.this.dateRegistration = dateRegistration;
            return this;
        }

        public CarBuilder setDateManufactured(java.sql.Date dateManufactured) {
            Car.this.dateManufactured = dateManufactured;
            return this;
        }

        public CarBuilder setEngineType(String engineType) {
            Car.this.engineType = engineType;
            return this;
        }

        public CarBuilder setEngineVolume(double engineVolume) {
            Car.this.engineVolume = engineVolume;
            return this;
        }

        public Car build() {
            return Car.this;
        }
    }

}
