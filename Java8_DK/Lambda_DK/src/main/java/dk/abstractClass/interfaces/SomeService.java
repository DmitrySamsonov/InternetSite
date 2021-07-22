package dk.abstractClass.interfaces;

public interface SomeService {
    public String text = "bla bla";
    public int number = 10;
//    private int number2 = 10;

    void doSomething();

//    public SomeService(){
//
//    }

    public default void java8Method() {

        System.out.println("bla");
    }


    private void methodPrivate() {
        System.out.println("asdf");
    }

    default void kostil() {
        methodPrivate();
    }
}
