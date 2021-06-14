package examples.toString;

import lombok.ToString;

@ToString
public class Person {
    private int id;
    private String name;
    private int age;
}

/*
public class Person {
    private int id;
    private String name;
    private int age;

    public Person() {
    }

    public String toString() {
        return "Person(id=" + this.id + ", name=" + this.name + ", age=" + this.age + ")";
    }
}

 */