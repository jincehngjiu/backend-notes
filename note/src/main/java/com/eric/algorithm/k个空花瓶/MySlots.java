package com.eric.algorithm.k个空花瓶;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author Eric Jin
 * @since 6/15/25 PM5:53
 */
public class MySlots {

    class MinQueue<E extends Comparable<E>> extends ArrayDeque<E> {
        private final Deque<E> minDeque;

        public MinQueue() {
            minDeque = new ArrayDeque<>();
        }

        @Override
        public void addLast(E e) {
            super.addLast(e);
            while (!minDeque.isEmpty() && e.compareTo(minDeque.peekLast()) < 0) {
                minDeque.pollLast();
            }
            minDeque.addLast(e);
        }

        @Override
        public E pollFirst() {
            E e = super.pollFirst();
            if (e == minDeque.peekFirst()) {
                minDeque.pollFirst();
            }
            return e;
        }

        public E min() {
            return minDeque.peekFirst();
        }
    }

    public int kEmptySlots(int[] flows, int k) {
        if (flows == null || flows.length < k + 2) {
            return -1;
        }
        int[] days = new int[flows.length];
        for (int i = 0; i < flows.length; i++) {
            days[flows[i] - 1] = i + 1;
        }
        MinQueue<Integer> slidingWindow = new MinQueue<>();
        int ans = days.length;
        for (int i = 0; i < days.length; i++) {
            slidingWindow.addLast(days[i]);
            if (slidingWindow.size() > k + 1) {
                int left = slidingWindow.pollFirst();
                Integer min = slidingWindow.min();
                int right = days[i];
                if (left < min && right < min) {
                    ans = Math.min(ans, Math.max(left, right));
                }
            }

        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}
