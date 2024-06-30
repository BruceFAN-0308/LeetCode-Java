package com.bruce.LC.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC46 {

    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return ans;
    }

    private void dfs(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }
            path.add(num);
            dfs(nums);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        for (List<Integer> integers : new LC46().permute(new int[]{1, 2, 3})) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
