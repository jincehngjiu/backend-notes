package com.eric.algorithm.文件夹文件数;

import java.io.File;
import java.util.Objects;
import java.util.Stack;

/**
 * <p>
 * 给定一个文件目录路径,写一个函数统计这个目录下所有的文件数量并返回
 * 隐藏文件也算,但是文件夹不算
 * </p>
 * 不使用递归,使用队列
 * @author Eric Jin
 * @since 6/18/25 PM10:07
 */
public class Solution {

    /**
    *<p>
    * 深度优先
    *</p>
    */
    public static int countFiles(String path) {
        File file = new File(path);
        if (!file.isDirectory() && !file.isFile()) {
            return 0;
        }
        if (file.isFile()) {
            return 1;
        }
        Stack<File> stack = new Stack<>();
        stack.add(file);
        int count = 0;
        while (!stack.isEmpty()) {
            File currentFile = stack.pop();
            for (File listFile : Objects.requireNonNull(currentFile.listFiles())) {
                if (listFile.isFile()) {
                    count++;
                } else if (listFile.isDirectory()) {
                    stack.push(listFile);
                }
            }
        }
        return count;
    }
}
