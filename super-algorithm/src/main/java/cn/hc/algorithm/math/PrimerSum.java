package cn.hc.algorithm.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hc on 2017/7/2.
 */
public class PrimerSum {
    public static void main(String[] args) {
        long former = System.currentTimeMillis();
        System.out.println(primeSum(1000000000));
        System.out.println("计算10亿以内质数和耗时"+(System.currentTimeMillis()-former)+"ms");
    }
    public static long primeSum(final int range) {
        int i, k;
        Map<Integer, Long> S = new HashMap<Integer, Long>();
        int r = (int) Math.sqrt(range);
        int p = range / r;
        int[] V = new int[r + p - 1];
        k = r + 1;
        for (i = 1; i < k; i++) {
            V[i - 1] = range / i;
        }
        int count = 1;
        for (i = r + p - 2; i >= r; i--) {
            V[i] = count++;
        }
        // ArrayUtils.printArray(V);
        for (i = 0; i < V.length; i++) {
            S.put(V[i], ((long) V[i] * (V[i] + 1) / 2 - 1));
        }
        // System.out.println(S);

        Long sp, p2;
        for (p = 2; p < r + 1; p++) {
            if (S.get(p) > S.get(p - 1)) {
                sp = S.get(p - 1);
                p2 = (long) (p * p);
                for (i = 0; i < V.length; i++) {
                    if (V[i] < p2) {
                        break;
                    }
                    S.put(V[i], S.get(V[i]) - p * (S.get(V[i] / p) - sp));
                }
            }
        }
        return S.get(range);
    }
}
