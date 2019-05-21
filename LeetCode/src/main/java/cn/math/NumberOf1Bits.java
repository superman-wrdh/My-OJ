package cn.math;

/**
 * Created by super on 2019/5/22
 * https://leetcode.com/problems/excel-sheet-column-title/submissions/
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (;n!=0;n = n & (n-1))
            count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Bits().hammingWeight(1));
        System.out.println(new NumberOf1Bits().hammingWeight(2));
        System.out.println(new NumberOf1Bits().hammingWeight(3));
        System.out.println(new NumberOf1Bits().hammingWeight(128));
    }
}
