package com.eric.algorithm.某次方;

/**
 * <p>
 * 给定一个非负整数num,
 * 如何不用循环语句
 * 返回>=num,并且离num最近的,2的某次方
 * </p>
 *
 * @author Eric Jin
 * @since 6/18/25 PM10:28
 */
public class Solution {

    public static int nextPowerOfTwo(int n) {
        n--;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : n + 1;
    }

    public static void main(String[] args) {

    }
}
