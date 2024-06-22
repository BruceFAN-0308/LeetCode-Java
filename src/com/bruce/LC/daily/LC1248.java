package com.bruce.LC.daily;

public class LC1248 {
    public int numberOfSubarrays(int[] nums, int k) {


        int result = 0;
        int i = 0;
        int leftIndex = 0;

        int oddCount = 0;
        while (i < nums.length) {
            if (nums[i] % 2 == 1) {
                oddCount++;
            }

            if (oddCount == k) {

                int evenCount = 0;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] % 2 != 0) {
                        break;
                    }
                    evenCount++;
                }
                int right = evenCount + 1;
                evenCount = 0;
                for (int j = leftIndex; nums[j] % 2 == 0; j++) {
                    evenCount++;
                    leftIndex++;
                }
                int left = evenCount + 1;
                result += left * right;
                leftIndex++;
                oddCount--;
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new LC1248().numberOfSubarrays(new int[]{33638, 68647, 19451, 77078, 82905, 28725, 39979, 72613, 56309, 52947, 35686, 13228, 11103, 45827, 73787, 22573, 92402, 94287, 89489, 19802, 94212, 28119, 99817, 59878, 96293, 17294, 9521, 86077, 49711, 71143}, 10));
//        System.out.println(new LC1248().numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
        System.out.println(new LC1248().numberOfSubarrays(new int[]{45627, 50891, 94884, 11286, 35337, 46414, 62029, 20247, 72789, 89158, 54203, 79628, 25920, 16832, 47469, 80909}, 1));
    }
}
