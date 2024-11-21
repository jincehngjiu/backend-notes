package com.eric.notes.Java8.stream.flapmap;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author Eric Jin
 * @since 2024/11/14 10:07
 */
public class Example {

    Stream<int[]> stream = IntStream.rangeClosed(1, 100).boxed()
            .flatMap(a -> IntStream.rangeClosed(a, 100)
                    .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                    .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));


}
