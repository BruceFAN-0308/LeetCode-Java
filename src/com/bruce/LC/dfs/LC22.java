package com.bruce.LC.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC22 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        backTracking("", ans, n, n);
        return ans;
    }

    private void backTracking(String currentStr, List<String> ans, int left, int right) {
        if (right < left) {
            return;
        }
        if (left == 0 && right == 0) {
            ans.add(currentStr);
            return;
        }
        if (left > 0) {
            backTracking(currentStr + "(", ans, left - 1, right);
        }
        if (right > 0) {
            backTracking(currentStr + ")", ans, left, right - 1);
        }
    }

    public static void main(String[] args) {
        for (String s : new LC22().generateParenthesis(3)) {
            System.out.print(s + " ");
        }
    }
}
