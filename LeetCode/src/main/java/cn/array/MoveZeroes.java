package cn.array;

public class MoveZeroes {
    /**
     * https://leetcode.com/problems/move-zeroes/
     * 283. Move Zeroes
     * Share
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *
     * Example:
     *
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Note:
     *
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     *
     */
    public static void main(String[] args) {
        //测试用例
    }

    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[count];
                nums[count] = nums[i]; // swap.
                nums[i] = temp;
                count++;
            }
        }
    }
}
