package examples.setter;

import lombok.Setter;

@Setter
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
*/
