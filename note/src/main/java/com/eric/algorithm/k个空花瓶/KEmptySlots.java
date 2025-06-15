package com.eric.algorithm.k个空花瓶;

import java.util.ArrayDeque;
import java.util.Deque;

public class KEmptySlots {

    /** 单调队列：允许 O(1) 获取当前所有元素的最小值 */
    static class MinQueue {
        Deque<Integer> data = new ArrayDeque<>();
        Deque<Integer> minq = new ArrayDeque<>();

        // 入队（相当于 addLast）
        void offer(int x) {
            data.offerLast(x);
            // 保持 minq 单调不降
            while (!minq.isEmpty() && minq.peekLast() > x) {
                minq.pollLast();
            }
            minq.offerLast(x);
        }

        // 出队（相当于 pollFirst）
        int poll() {
            int x = data.pollFirst();
            if (x == minq.peekFirst()) {
                minq.pollFirst();
            }
            return x;
        }

        // 获取最小值
        int min() {
            return minq.peekFirst();
        }

        // 当前队列大小
        int size() {
            return data.size();
        }
    }

    /**
     * @param flows 第 d 天开放第 flows[d-1] 号花
     * @param k     两株花恰好隔 k 盆
     * @return 最早满足条件的天数；不存在则 -1
     */
    public static int kEmptySlots(int[] flows, int k) {
        int n = flows.length;
        if (n < k + 2) {
            return -1;
        }

        // 1. 构造 bloomDay：第 i 号花何时开放
        int[] bloomDay = new int[n];
        for (int d = 0; d < n; d++) {
            bloomDay[flows[d] - 1] = d + 1;
        }

        MinQueue window = new MinQueue();
        int ans = Integer.MAX_VALUE;

        // 2. 滑动窗口
        for (int i = 0; i < n; i++) {
            window.offer(bloomDay[i]);

            // 窗口满 k+2 时，准备判断
            if (window.size() > k + 1) {
                // 弹出的即为“左端” leftDay
                int leftDay = window.poll();
                // 此时队列里剩 k+1 个：mid₁…midₖ + right
                int midMin = window.min();        // 中间 k 盆的最早开放日
                int rightDay = bloomDay[i];       // 窗口最右端

                // 判断 leftDay 和 rightDay 都先于 midMin
                if (leftDay < midMin && rightDay < midMin) {
                    // 这一天即可形成“k 空槽”
                    ans = Math.min(ans, Math.max(leftDay, rightDay));
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // 简单测试
    public static void main(String[] args) {
        int[] flows = {3,1,5,4,2};
        System.out.println(kEmptySlots(flows, 1));  // 输出 3
    }
}
