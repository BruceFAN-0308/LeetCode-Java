package com.everyday.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-14 12:47
 **/
public class LC945 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 7, 7, 7};
        LC945 lc945 = new LC945();
        System.out.println(lc945.minIncrementForUnique(nums));
//        System.out.println(lc945.minIncrementForUniqueSolution2(nums));
    }

    // solution sorting
    public int minIncrementForUnique(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        Arrays.sort(nums);
        int moves = 0;

        for (int i = 1; i < nums.length; i++) {
            while (nums[i] <= nums[i - 1]) {
                nums[i]++;
                moves++;
            }
        }

        return moves;
    }

    // solution counting
    public int minIncrementForUniqueSolution2(int[] nums) {

        // counter数组统计每个数字的个数。
        //（这里为了防止下面遍历counter的时候每次都走到40000，所以设置了一个max，这个数据量不设也行，再额外设置min也行）
        int[] counter = new int[9];
        int max = -1;
        for (int num: nums) {
            counter[num]++;
            max = Math.max(max, num);
        }

        // 遍历counter数组，若当前数字的个数cnt大于1个，则只留下1个，其他的cnt-1个后移
        int move = 0;
        for (int num = 0; num <= max; num++) {
            if (counter[num] > 1) {
                int d = counter[num] - 1;
                move += d;
                counter[num + 1] += d;
            }
        }
        // 最后, counter[max+1]里可能会有从counter[max]后移过来的，counter[max+1]里只留下1个，其它的d个后移。
        // 设 max+1 = x，那么后面的d个数就是[x+1,x+2,x+3,...,x+d],
        // 因此操作次数是[1,2,3,...,d],用求和公式求和。
        int d = counter[max + 1] - 1;
        move += (1 + d) * d / 2;
        return move;

    }
}
