package al.example5_generalTypeT;

@FunctionalInterface
public interface Operations<T> {
    T getResult(T value1, T value2);
}
