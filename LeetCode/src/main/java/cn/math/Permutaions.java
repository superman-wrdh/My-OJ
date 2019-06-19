package cn.math;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutaions {
    // 1 2 3, 1 2 3
    // while sequence fewer to equal to the nums.length:
    //   pop queue
    //   for digit in nums:
    //     add the new digit(not exists) to the popped list
    //     push this sequence to the queue
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteHelper(nums, new ArrayList<Integer>(), res);
        return res;
    }

    private void permuteHelper(int[] nums, List<Integer> buffer, List<List<Integer>> res) {
        if (nums.length == buffer.size()) {
            res.add(new ArrayList<>(buffer));
            return;
        }
        for (int n : nums) {
            if (!buffer.contains(n)) {
                buffer.add(n);
                permuteHelper(nums, buffer, res);
                buffer.remove(buffer.size() - 1);
            }
        }
    }
}
