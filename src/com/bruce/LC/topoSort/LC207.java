package com.bruce.LC.topoSort;

import java.util.*;

public class LC207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //定义入度数组，索引处（课程号）对应入度，比如课程0的入度为0
        int[] inDegree = new int[numCourses];
        //定义map数组，key课程号，value：依赖key的课程号，比如key为1，依赖的value为3，4
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            //遍历依赖关系表；在入度数组对应索引处++
            inDegree[prerequisite[0]]++;
            //没有对map初始化，这里对map初始化一个list数组，存放依赖的课程
            map.putIfAbsent(prerequisite[1], new ArrayList<>());
            //在对应被依赖课程key处添加依赖key的课程
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        //新建列表，把入度为0的课放进来
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                que.push(i);
            }
        }

        while (!que.isEmpty()) {
            //弹出已选课程，在map找到依赖它的课程，在入度数组--
            int course = que.poll();
            numCourses--;

            List<Integer> list = map.get(course);
            if (list == null) {
                continue;
            }
            for (Integer nextCourse : list) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    que.push(nextCourse);
                }
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        System.out.println(new LC207().canFinish(6, new int[][]{
                {3, 0}, {3, 1}, {4, 1}, {4, 2}, {5, 3}, {5, 4}
        }));
    }
}
