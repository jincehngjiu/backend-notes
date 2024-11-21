package com.eric.notes.Java8.stream.file;

import java.io.File;
import java.io.FileFilter;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author Eric Jin
 * @since 2024/11/11 15:42
 */
public class FileExample {

    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        //----------------------------分隔符------------------------------------

        File[] hiddenFile = new File(".").listFiles(File::isHidden);


    }
}
