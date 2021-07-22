package dk.example5_generalTypeT;

@FunctionalInterface
public interface Operation<T> {

    T getResult(T value1, T value2);

}
