package com.bruce.LC.dfs;

import java.util.*;

public class LC78 {
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    private void dfs(int[] nums, int index) {
        ans.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        for (List<Integer> subset : new LC78().subsets(new int[]{1, 2, 3})) {
            for (Integer i : subset) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
