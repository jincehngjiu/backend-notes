package com.eric.algorithm.数组中最长山峰;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author Eric Jin
 * @since 6/15/25 AM9:56
 */
public class Solution {
    enum MountainPosition {
        UP, DOWN, INVALID
    }
    public static int longestMountain(int[] arr) {
        int maxLength = 0,currentLength = 0;
        MountainPosition status = MountainPosition.INVALID;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] < arr[i]) {
                switch (status) {
                    case UP -> currentLength++;
                    default -> {
                        maxLength = Math.max(maxLength, currentLength);
                        currentLength = 2; // 重置为2，因为当前元素和前一个元素构成上升
                        status = MountainPosition.UP;
                    }
                }
            } else if (arr[i-1] > arr[i]) {
                switch (status) {
                    case DOWN -> {
                        currentLength++;
                        maxLength = Math.max(maxLength, currentLength);
                    }
                    case UP -> {
                        currentLength++;
                        maxLength = Math.max(maxLength, currentLength);
                        status = MountainPosition.DOWN;
                    }
                    default -> {
                        currentLength = 0; // 重置为0，因为当前元素和前一个元素不构成山峰
                        status = MountainPosition.INVALID;
                    }
                }
            }
            else {
                // 遇到相等的情况，重置状态和长度
                currentLength = 0;
                status = MountainPosition.INVALID;
            }
        }
        return maxLength >= 3 ? maxLength : 0; // 至少需要3个元素才能构成山峰
    }

    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{2, 1, 4, 7, 3,4,5,6,7,8,9,8,7,6,5}));
    }
}
