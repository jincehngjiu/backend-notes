package com.eric.algorithm.k个空花瓶;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author Eric Jin
 * @since 6/15/25 PM2:28
 */
public class Solution {

    class MinQueue<E extends Comparable<E>> extends ArrayDeque<E> {
        private final Deque<E> minDeque;

        public MinQueue() {
            minDeque = new ArrayDeque<>();
        }

        @Override
        public void addLast(E e) {
            super.addLast(e);
            while (!minDeque.isEmpty() &&e.compareTo(minDeque.peekLast()) < 0) {
                minDeque.pollLast();
            }
            this.minDeque.addLast(e);
        }

        @Override
        public E pollFirst() {
            E x = super.pollFirst();
            if (x == minDeque.peekFirst()) {
                minDeque.pollFirst();
            }
            return x;
        }

        public E min() {
            return minDeque.peekFirst();
        }
    }

    public int kEmptySlots(int[] flows, int k) {
        MinQueue<Integer> slidingWindow = new MinQueue<>();
        int[] flowerBloomDays = new int[flows.length];
        for (int i = 0; i < flows.length; i++) {
            flowerBloomDays[flows[i] - 1] = i + 1;
        }
        int ans = flowerBloomDays.length;
        for (int i = 0; i < flowerBloomDays.length; i++) {
            slidingWindow.addLast(flowerBloomDays[i]);
            if (i < k) {
                continue;
            }
            slidingWindow.pollFirst();
            if (k == 0 || flowerBloomDays[i-k] < slidingWindow.min() && flowerBloomDays[i +1] < slidingWindow.min()) {
                ans = Math.min(ans, Math.max(flowerBloomDays[i-k], flowerBloomDays[i+1]));
            }
        }

        return ans <flowerBloomDays.length ? ans : -1;
    }

}
