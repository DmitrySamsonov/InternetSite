package my.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    private long id;
    private String name;
    private int age;

}
