package dk.abstractClass;

public class Main2 {

    public static void main(String[] args) {

        Bmw bmw = new Bmw();

        bmw.pizdez();
        bmw.engineSound();



        Corch corch = new Corch() {
            @Override
            public void pizdez() {

            }
        };


    }
}
