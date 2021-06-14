package examples.builder;

public class Using {
    public static void main(String[] args) {
        Car car = Car.builder().id(15).mark("Opel").model("A6").build();
        System.out.println(car);
    }
}
