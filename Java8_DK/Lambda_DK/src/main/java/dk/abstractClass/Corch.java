package dk.abstractClass;

public abstract class  Corch {
    private String model;
    private int doors = 4;
    private int number2 = 10;


    public Corch() {
    }

    public Corch(String model, int doors) {
        this.model = model;
        this.doors = doors;
    }

    public void engineSound(){
        System.out.println("wrrrrrrrrrrr");

    }

    public abstract void pizdez();

}
