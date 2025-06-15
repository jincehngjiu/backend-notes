package com.eric.domain.queensproblem.entity;

import lombok.Value;

/**
 * <p>
 * 皇后实体,采用充血模型(不仅包含属性还具有行为)
 * "@Value"注解可以全速构建一个不可变对象,编译后将属性添加private final 修饰符,get(),toString()方法等
 * </p>
 *
 * @author Eric Jin
 * @since 3/20/25 PM11:07
 */
@Value
public class Queen {
    /**
    *<p>
    * 行
    *</p>
    */
    int row;

    /**
    *<p>
    * 列
    *</p>
    */
    int col;

    /**
     *<p>
     * 检测是否与其他皇后 位于同一行、同一列或同一斜线上
     *</p>
     *
     * @author Eric Jin
     * @since 3/20/25 PM11:10
     * @param other :
     * @return :{@link boolean}
     */
    public boolean conflictsWith(Queen other) {
        return true;
    }

    public static void main(String[] args) {
        int site =8;
        for (int i = 0; i < site; i++) {
            for (int j = 0; j < site; j++) {
                System.out.print("*/t");
            }
            System.out.println();
        }
    }
}
