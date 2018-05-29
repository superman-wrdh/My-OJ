package cn.array;

import java.util.HashMap;

/**
 * Created by super on 2018/5/29
 * Contains Duplicate
 * Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 * <p>
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return false;
        }
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        count.put(nums[0], 1);

        for (int i = 1; i < nums.length; i++) {
            int tempKey = nums[i];
            if (count.get(tempKey) != null) {
                return true;
            } else {
                count.put(tempKey, 1);
            }
        }

        return false;
    }
}
