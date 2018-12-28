package cn.math;

/**
 * 统计一个数二进制含有多少个1
 */
public class CountBin {
    public static void main(String[] args) {
        System.out.println(numberOfOne(53));
    }

    public static int numberOfOne(int n) {
        int count = 0;
        while (n != 0) {
            System.out.println("#");
            count++;
            n = n & (n - 1);
        }
        return count;
    }

}
