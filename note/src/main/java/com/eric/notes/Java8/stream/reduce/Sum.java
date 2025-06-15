//package com.eric.notes.Java8.stream.reduce;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.function.BiFunction;
//import java.util.function.IntUnaryOperator;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
//import static java.util.Map.entry;
//
///**
// * <p>
// * 归约
// * </p>
// *
// * @author Eric Jin
// * @since 11/23/24 PM12:56
// */
//public class Sum {
//
//    public int sum() {
//        List<Integer> items = List.of(1, 2, 3);
//        return items.stream().reduce(0, (a, b) -> a + b);
////        return items.stream().reduce(0, Integer::sum);
//    }
//
//    public Optional<Integer> max() {
//        List<Integer> items = List.of(1, 2, 3, 4, 5);
//        return items.stream().reduce((a, b) -> a > b ? a : b);
////        IntUnaryOperator
////        return items.stream().reduce(Integer::max);
//        IntStream.rangeClosed(1, 100)
//                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
//                .boxed()
//                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});
//    }
//
//    public void aa() {
//        Stream<int[]> pythagoreanTriples =
//                IntStream.rangeClosed(1, 100).boxed()
//                        .flatMap(a ->
//                                IntStream.rangeClosed(a, 100)
//                                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
//                                        .mapToObj(b ->
//                                                new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
//                        );
//        Map<String, Integer> ageOfFriends
//                = Map.ofEntries(entry("Raphael", 30),
//                entry("Olivia", 25),
//                entry("Thibaut", 26));
////        ageOfFriends.computeIfPresent()
//        System.out.println(ageOfFriends);
//        int a =10;
//        Runnable r2 = new Runnable(){
//            public void run(){
//                int a = 2;
//                System.out.println(a);
//            }
//        };
//    }
//
//}
