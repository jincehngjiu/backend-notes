package com.eric.notes.Java8.stream.sort;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * <p>
 * 排序示例
 * </p>
 *
 * @author Eric Jin
 * @since 2024/11/11 10:52
 */
public class SortExample {

    public static void main(String[] args) {




        List<Apple> build = Lists.newArrayList(Apple.builder().weight("1").build(),Apple.builder().weight("2").build());
        Long collect = build.stream().collect(Collectors.counting());

        Collections.sort(build, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        build.sort(comparing(Apple::getWeight));
        for (int i = 0; i < build.toArray().length; i++) {

        }


    }


}
