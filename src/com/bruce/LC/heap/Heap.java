package com.bruce.LC.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void insert(Integer val) {
        heap.add(val);
        siftUp(heap.size() - 1);
    }

    private void buildMaxHeap(List<Integer> nums) {
        heap = new ArrayList<>(nums);
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            siftDown(i, heap.size());
        }
    }

    public int extractMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap.get(0);
        int lastVal = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastVal);
            siftDown(0, heap.size());
        }
        return max;
    }

    public void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index) < heap.get(parentIndex)) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    public void siftDown(int index, int range) {
        int leftChild = 2 * index + 1;
        int rightChild, maxIndex;
        while (leftChild < range) {
            rightChild = leftChild + 1;
            maxIndex = leftChild;
            if (rightChild < range && heap.get(rightChild) > heap.get(leftChild)) {
                maxIndex = rightChild;
            }
            if (heap.get(maxIndex) < heap.get(index)) {
                break;
            }
            swap(index, maxIndex);
            index = maxIndex;
            leftChild = 2 * index + 1;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void sort() {
        for (int i = heap.size() - 1; i >= 0; i--) {
            swap(0, i);
            siftDown(0, i);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.buildMaxHeap(Arrays.asList(10, 20, 5, 7, 30, 15, 25));

        heap.insert(10);
        heap.sort();
        for (Integer i : heap.heap) {
            System.out.println(i);
        }

    }
}