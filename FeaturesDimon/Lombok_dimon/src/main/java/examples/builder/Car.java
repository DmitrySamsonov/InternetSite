package examples.builder;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
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
}
