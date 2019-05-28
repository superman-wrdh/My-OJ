package cn.math;

import java.util.Arrays;

/**
 * Created by super on 2019/5/28
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        int sum = Arrays.stream(nums).sum();
        return ((max+min)*nums.length+1) / 2 -sum;
    }

    public static void main(String[] args) {
        int arr[] = {0,1,3};
        System.out.println(new MissingNumber().missingNumber(arr));
    }
}
