package examples.allArgsConstructor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
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

        public Person(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
 */