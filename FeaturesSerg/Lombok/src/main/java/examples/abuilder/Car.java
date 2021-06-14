package examples.abuilder;


import lombok.Builder;
import lombok.ToString;

import java.util.Date;


@Builder
@ToString
public class Car {

    private int id;
    private String mark;
    private String model;
//    private Date dateRegistration;
//    private java.sql.Date dateManufactured;
    private int doorNumbers;
    private String color;
    private String engineType;
    private double engineVolume;



}
