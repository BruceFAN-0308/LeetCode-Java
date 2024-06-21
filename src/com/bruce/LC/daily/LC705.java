package com.bruce.LC.daily;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-04-13 13:40
 **/
public class LC705 {

    private final Integer BASE = 79;

    private LinkedList[] linkedList = new LinkedList[BASE];

    public LC705() {
        for (int i = 0; i < linkedList.length; i++) {
            linkedList[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int hash = hash(key);
        LinkedList list = linkedList[hash];
        for (Object o : list) {
            if (Objects.equals(key, o)) {
                return;
            }
        }
        list.add(key);
    }

    public void remove(int key) {
        int hash = hash(key);
        LinkedList list = linkedList[hash];
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(key, list.get(i))) {
                list.remove(i);
                return;
            }
        }
        return;
    }

    public boolean contains(int key) {
        int hash = hash(key);
        LinkedList list = linkedList[hash];
        for (Object o : list) {
            if (Objects.equals(key, o)) {
                return true;
            }
        }
        return false;
    }

    public int hash(int key) {
        return key % BASE;
    }

    public static void main(String[] args) {
        LC705 myHashSet = new LC705();
        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.contains(1);
        myHashSet.contains(3);
        myHashSet.add(2);
        myHashSet.contains(2);
        myHashSet.remove(2);
        myHashSet.contains(2);
    }
}