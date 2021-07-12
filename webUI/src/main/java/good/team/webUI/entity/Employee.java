package good.team.webUI.entity;

public class Employee {

    private int id;
    private String lastName;
    private String firstName;
    private int age;

    public Employee(int id, String lastName, String firstName, int age) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public Employee(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
