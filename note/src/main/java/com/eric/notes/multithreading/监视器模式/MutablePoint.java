package com.eric.notes.multithreading.监视器模式;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author Eric Jin
 * @since 2024/12/16 14:59
 */
public class MutablePoint {

    public int x, y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }


    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}
