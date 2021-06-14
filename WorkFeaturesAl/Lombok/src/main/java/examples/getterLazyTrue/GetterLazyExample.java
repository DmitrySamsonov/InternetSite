package examples.getterLazyTrue;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicReference;

public class GetterLazyExample {
    @Getter(lazy = true)
    private final double[] cashed = expencive();

    private double[] expencive() {
        double[] result = new double[1_000_000];
        for (int i = 0; i < result.length; i++) {
        result[i]=i;

        }
        return result;
    }
}
//
//public class GetterLazyExample {
//    private final AtomicReference<Object> cashed = new AtomicReference();
//
//    public GetterLazyExample() {
//    }
//
//    private double[] expencive() {
//        double[] result = new double[1000000];
//
//        for(int i = 0; i < result.length; ++i) {
//            result[i] = (double)i;
//        }
//
//        return result;
//    }
//
//    public double[] getCashed() {
//        Object value = this.cashed.get();
//        if (value == null) {
//            synchronized(this.cashed) {
//                value = this.cashed.get();
//                if (value == null) {
//                    double[] actualValue = this.expencive();
//                    value = actualValue == null ? this.cashed : actualValue;
//                    this.cashed.set(value);
//                }
//            }
//        }
//
//        return (double[])(value == this.cashed ? null : value);
//    }
//}

