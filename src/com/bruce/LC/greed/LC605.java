package com.bruce.LC.greed;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-18 20:37
 **/
public class LC605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            boolean left = i == 0 || flowerbed[i - 1] == 0;
            boolean right = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;

            if (left && right && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n == 0;
    }

    public static void main(String[] args) {
        System.out.println(new LC605().canPlaceFlowers(new int[]{1, 0}, 1));
    }
}
