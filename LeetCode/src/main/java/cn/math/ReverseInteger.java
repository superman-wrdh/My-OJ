package cn.math;

public class ReverseInteger {
    /**
     * Reverse Integer
     * Given a 32-bit signed integer, reverse digits of an integer.
     * <p>
     * Example 1:
     * <p>
     * Input: 123
     * Output: 321
     * Example 2:
     * <p>
     * Input: -123
     * Output: -321
     * Example 3:
     * <p>
     * Input: 120
     * Output: 21
     * Note:
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
     */
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    public int reverse2(int x) {
        int po = 1;
        if (x < 0) {
            po = -1;
            x = -x;
        }
        int result = 0;
        int power = -1;
        int cx = x;
        while (cx != 0) {
            cx = cx / 10;
            power++;
        }
        boolean zero = false;
        while (x != 0) {
            int tail = x % 10;
            if ((long) tail * (long) Math.pow(10, power) > Integer.MAX_VALUE || (long) tail * (long) Math.pow(10, power) < Integer.MIN_VALUE) {
                zero = true;
                break;
            }
            result = result + tail * (int) Math.pow(10, power);
            power--;
            x = x / 10;
        }
        return (zero ? 0 : result) * po;

    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(1563847412));
        System.out.println(new ReverseInteger().reverse2(1563847412));
        System.out.println(Long.MAX_VALUE);
    }
}
