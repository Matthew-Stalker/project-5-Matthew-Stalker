package com.example.sorting;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SortingDriver {

    public static void main(String[] args) {
        int arraySize = 10000;

        // 1. Generate RANDOM array
        Integer[] randomArr = IntStream.generate(() -> (int) (Math.random() * 50000))
                .boxed()
                .limit(arraySize)
                .toArray(Integer[]::new);

        // 2. Generate SORTED array (0 to 9999)
        Integer[] sortedArr = IntStream.range(0, arraySize)
                .boxed()
                .toArray(Integer[]::new);

        // 3. Generate REVERSE SORTED array (10000 down to 1)
        Integer[] reverseArr = IntStream.iterate(arraySize, i -> i - 1)
                .limit(arraySize)
                .boxed()
                .toArray(Integer[]::new);

        // Run the tests
        System.out.println("=========================================");
        System.out.println("        TESTING RANDOM ARRAY             ");
        System.out.println("=========================================");
        runPerformanceTest(randomArr);

        System.out.println("\n=========================================");
        System.out.println("        TESTING SORTED ARRAY             ");
        System.out.println("=========================================");
        runPerformanceTest(sortedArr);

        System.out.println("\n=========================================");
        System.out.println("      TESTING REVERSE SORTED ARRAY       ");
        System.out.println("=========================================");
        runPerformanceTest(reverseArr);
    }

    private static void runPerformanceTest(Integer[] sourceArray) {
        Integer[] copy1 = copyArray(sourceArray);
        Integer[] copy2 = copyArray(sourceArray);
        Integer[] copy3 = copyArray(sourceArray);

        StopWatch stopWatch = new StopWatch();

        // Gnome Sort
        stopWatch.start("Gnome Sort");
        SortingUtility.gnomeSort(copy1);
        stopWatch.stop();

        // Cocktail Shaker Sort
        stopWatch.start("Cocktail Shaker Sort");
        SortingUtility.cocktailShakerSort(copy2);
        stopWatch.stop();

        // Shell Sort
        stopWatch.start("Shell Sort");
        SortingUtility.shellSort(copy3);
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }

    private static <T> T[] copyArray(T[] obj) {
        return (T[]) Arrays.copyOf(obj, obj.length);
    }
}