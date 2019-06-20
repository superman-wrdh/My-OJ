package cn.math;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    List<List<Integer>> sums = new LinkedList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, new LinkedList(), 0, target);
        return sums;
    }

    public void backtrack(int[] candidates, LinkedList<Integer> sum, int start, int remain) {
        if (remain < 0) return;
        if (remain == 0) {
            sums.add(new LinkedList(sum));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            sum.add(candidates[i]);
            backtrack(candidates, sum, i, remain - candidates[i]);
            sum.remove(sum.size() - 1);
        }
    }
}
