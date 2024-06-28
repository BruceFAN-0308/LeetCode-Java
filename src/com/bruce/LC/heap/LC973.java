package com.bruce.LC.heap;

import java.util.PriorityQueue;

public class LC973 {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>
                (((o1, o2) -> (o2[0] * o2[0] + o2[1] * o2[1]) - (o1[0] * o1[0] + o1[1] * o1[1])));

        for (int i = 0; i < points.length; i++) {
            if (i < k) {
                queue.add(points[i]);
            } else if (queue.peek()[0] * queue.peek()[0] + queue.peek()[1] * queue.peek()[1] > (points[i][0] * points[i][0] + points[i][1] * points[i][1])) {
                queue.poll();
                queue.add(points[i]);
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        for (int[] ints : new LC973().kClosest(new int[][]{
                {-5, 4}, {-6, -5}, {4, 6}
        }, 2)) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
