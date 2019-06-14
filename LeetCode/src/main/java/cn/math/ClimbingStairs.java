package cn.math;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/climbing-stairs/submissions/
public class ClimbingStairs {

    public int climbStairs(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return help(cache, n);
    }

    public int help(Map<Integer, Integer> cache, int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        Integer c = cache.get(n);
        if (c != null) return c;
        int value = help(cache, n - 1) + help(cache, n - 2);
        cache.put(n, value);
        return value;
    }

}
