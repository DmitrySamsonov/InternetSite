package al.example1;

public class OperationImplementation implements Operation {
    @Override
    public double getResult(double value1, double value2) {
        return value1 + value2 + 100;
    }
}
