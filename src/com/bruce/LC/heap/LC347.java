package com.bruce.LC.heap;

import java.util.*;

public class LC347 {

    // by map
    public int[] topKFrequent(int[] nums, int k) {
        int[] results = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < results.length; i++) {
            int max = 0;
            int key = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (max < entry.getValue()) {
                    max = entry.getValue();
                    key = entry.getKey();
                }
            }
            results[i] = key;
            map.remove(key);
        }

        return results;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (i < k) {
                queue.add(entry.getKey());
            } else if (entry.getValue() > map.get(queue.peek())) {
                queue.poll();
                queue.add(entry.getKey());
            }
            i++;
        }

        // 取出最小堆中的元素
        int[] results = new int[k];
        for (int j = 0; j < results.length; j++) {
            results[j] = queue.poll();
        }
        return results;
    }


    // by heap
    public int[] topKFrequentByHeap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] numCount = new int[k];
        int a = 0;


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (a < k - 1) {
                numCount[a] = entry.getKey();
            } else if (a == k - 1) {
                numCount[a] = entry.getKey();
                buildHeap(numCount, map);
            } else if (entry.getValue() > map.get(numCount[0])) {
                numCount[0] = entry.getKey();
                buildHeap(numCount, map);
            }
            a++;
        }
        return numCount;
    }


    private void buildHeap(int[] nums, Map<Integer, Integer> map) {
        int length = nums.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            int index = i;
            int leftChild = 2 * index + 1;
            while (leftChild < length) {
                int rightChild = leftChild + 1;
                int minIndex = leftChild;
                if (rightChild < length && map.get(nums[rightChild]) < map.get(nums[leftChild])) {
                    minIndex = rightChild;
                }
                if (map.get(nums[minIndex]) > map.get(nums[index])) {
                    break;
                }
                swap(nums, index, minIndex);
                index = minIndex;
                leftChild = 2 * index + 1;

            }
        }
    }


    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        for (int i : new LC347().topKFrequent1(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6}, 7)) {
            System.out.println(i);
        }
    }
}
