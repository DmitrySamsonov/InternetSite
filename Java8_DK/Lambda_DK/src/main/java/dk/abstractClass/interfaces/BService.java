package dk.abstractClass.interfaces;

public class BService implements SomeService {


//    public String text = "bla bla";
//    public int number = 10;
//
//    abstract void doSomething();

    public void testInterfacesVariables() {
        System.out.println(text);
        System.out.println(number);
    }

    @Override
    public void doSomething() {

    }
}
