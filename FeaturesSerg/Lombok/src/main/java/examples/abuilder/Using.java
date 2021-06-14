package examples.abuilder;

public class Using {

    public static void main(String[] args) {

        Car car1 = Car.builder().id(5).mark("audi").model("a6").build();
        System.out.println(car1);
    }

}
