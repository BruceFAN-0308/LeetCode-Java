package com.bruce.LC.topoSort;

import java.util.*;

class LC210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            map.putIfAbsent(prerequisite[1], new ArrayList<>());
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                deque.push(i);
            }
        }
        int[] res = new int[numCourses];
        int i = 0;
        while (!deque.isEmpty()) {
            Integer course = deque.poll();
            res[i] = course;
            i++;
            List<Integer> list = map.get(course);
            if (list == null) {
                continue;
            }
            for (Integer nextCourse : list) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    deque.push(nextCourse);
                }
            }
        }

        return i == numCourses ? res : new int[0];
    }

    public static void main(String[] args) {
        for (int i : new LC210().findOrder(6, new int[][]{
                {3, 0}, {3, 1}, {4, 1}, {4, 2}, {5, 3}, {5, 4}
        })) {
            System.out.println(i);
        }
    }
}
