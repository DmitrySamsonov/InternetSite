package my.app.entity;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private long id;
    private String name;
    private int age;



    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


}
