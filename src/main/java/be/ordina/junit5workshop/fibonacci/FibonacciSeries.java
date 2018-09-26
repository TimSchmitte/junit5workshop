package be.ordina.junit5workshop.fibonacci;

import static java.lang.Math.*;

public class FibonacciSeries {
    public long getNumberForRank(int i) {
        long a = 0;
        long b = 1;

        if (i == 0) {
            return a;
        }
        if (i == 1) {
            return b;
        }
        for (int j = 0; j < i ; j++) {
            long oldA = a;
            a = a + b;
            b = oldA;
        }

        return a;
    }

    public boolean isPartOfSequence(long x) {
        final double fiveXPower2OfNumber = 5 * pow(x, 2);
        System.out.println(x+ "\t" + fiveXPower2OfNumber);
        return sqrt(fiveXPower2OfNumber -4) % 1 == 0|| sqrt(fiveXPower2OfNumber +4) % 1 == 0;
    }


}
