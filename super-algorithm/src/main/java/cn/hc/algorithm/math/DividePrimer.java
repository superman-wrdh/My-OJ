package cn.hc.algorithm.math;

/**
 * Created by hc on 2017/7/2.
 */

/**
 * 任何一个数都可以分解成质数相乘
 */
public class DividePrimer {
    public static void main(String[] args) {
        fen(100);
    }
    public static void fen(int n)
    {
        System.out.print(n+"=");
        for (int i = 2; i <= n; i++) {
            while (n!=i) {
                if (n%i==0) {
                    System.out.print(i+"*");
                    n=n/i;
                }else {
                    break;
                }

            }
        }
        System.out.println(n);
    }
}

