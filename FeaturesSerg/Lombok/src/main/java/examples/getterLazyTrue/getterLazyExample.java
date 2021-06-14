package examples.getterLazyTrue;

import lombok.Getter;

public class getterLazyExample {

    @Getter (lazy = true)
    private final double[] cached = expensive();

    private double[] expensive() {

        double[] result = new double[1_000_000];

        for (int i = 0; i < result.length; i++) {

            result[i] = i;

        }
        return result;

    }


}
