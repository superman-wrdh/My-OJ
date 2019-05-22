package cn.math;

/**
 * Created by super on 2019/5/22
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int newDigits[] = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }


    public static void main(String[] args) {
        int a[] = {9};
        int[] ints = new PlusOne().plusOne(a);
        System.out.println(ints[0]);
    }

}
