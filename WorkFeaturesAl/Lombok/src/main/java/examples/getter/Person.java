package examples.getter;

import lombok.Getter;

@Getter
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

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
*/