package dk.abstractClass.interfaces;

public class Main {
    public static void main(String[] args) {

        BService bService = new BService();
        bService.doSomething();
        bService.java8Method();


//        var2.0

        SomeService someService = new SomeService() {
            @Override
            public void doSomething() {

            }
        };

    }
}
