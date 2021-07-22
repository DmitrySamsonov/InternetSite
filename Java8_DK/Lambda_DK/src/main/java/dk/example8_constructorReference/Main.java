package dk.example8_constructorReference;

public class Main {
    public static void main(String[] args) {

        UserOperation operation = User::new;
        User user = operation.create("Imja", "1234");

        System.out.printf("name: %s%nPassword: %s", user.getName(), user.getPassword());

        System.out.println("");

        User user1 = new User("Imja2", "5678");
        System.out.printf("name: %s%nPassword: %s", user1.getName(), user1.getPassword());
    }
}
