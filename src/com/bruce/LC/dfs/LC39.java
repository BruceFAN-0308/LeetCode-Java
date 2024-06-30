package com.bruce.LC.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC39 {

    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, 0, target);
        return ans;
    }

    private void dfs(int[] candidates, int index, int sum, int target) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            dfs(candidates, i, sum, target);
            sum -= candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new LC39().combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> integers : lists) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
