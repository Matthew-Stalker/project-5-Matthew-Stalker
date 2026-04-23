package com.example.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class SortingUtilityTest {

    // --- 1. Empty Array ---
    @Test
    void testEmptyArray() {
        Integer[] expected = {};

        Integer[] gnomeArr = {};
        Integer[] cocktailArr = {};

        SortingUtility.gnomeSort(gnomeArr);
        SortingUtility.cocktailShakerSort(cocktailArr);

        assertArrayEquals(expected, gnomeArr, "Gnome Sort failed on empty array");
        assertArrayEquals(expected, cocktailArr, "Cocktail Shaker Sort failed on empty array");
    }

    // --- 2. Single Element ---
    @Test
    void testSingleElement() {
        Integer[] expected = {5};

        Integer[] gnomeArr = {5};
        Integer[] cocktailArr = {5};

        SortingUtility.gnomeSort(gnomeArr);
        SortingUtility.cocktailShakerSort(cocktailArr);

        assertArrayEquals(expected, gnomeArr, "Gnome Sort failed on single element array");
        assertArrayEquals(expected, cocktailArr, "Cocktail Shaker Sort failed on single element array");
    }

    // --- 3. Already Sorted ---
    @Test
    void testAlreadySorted() {
        Integer[] expected = {1, 2, 3, 4, 5};

        Integer[] gnomeArr = {1, 2, 3, 4, 5};
        Integer[] cocktailArr = {1, 2, 3, 4, 5};

        SortingUtility.gnomeSort(gnomeArr);
        SortingUtility.cocktailShakerSort(cocktailArr);

        assertArrayEquals(expected, gnomeArr, "Gnome Sort failed on already sorted array");
        assertArrayEquals(expected, cocktailArr, "Cocktail Shaker Sort failed on already sorted array");
    }

    // --- 4. Reverse Sorted ---
    @Test
    void testReverseSorted() {
        Integer[] expected = {1, 2, 3, 4, 5};

        Integer[] gnomeArr = {5, 4, 3, 2, 1};
        Integer[] cocktailArr = {5, 4, 3, 2, 1};

        SortingUtility.gnomeSort(gnomeArr);
        SortingUtility.cocktailShakerSort(cocktailArr);

        assertArrayEquals(expected, gnomeArr, "Gnome Sort failed on reverse sorted array");
        assertArrayEquals(expected, cocktailArr, "Cocktail Shaker Sort failed on reverse sorted array");
    }

    // --- 5. Duplicates ---
    @Test
    void testDuplicates() {
        Integer[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 6, 9};

        Integer[] gnomeArr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        Integer[] cocktailArr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};

        SortingUtility.gnomeSort(gnomeArr);
        SortingUtility.cocktailShakerSort(cocktailArr);

        assertArrayEquals(expected, gnomeArr, "Gnome Sort failed on array with duplicates");
        assertArrayEquals(expected, cocktailArr, "Cocktail Shaker Sort failed on array with duplicates");
    }

    // --- 6. All Same Elements ---
    @Test
    void testAllSameElements() {
        Integer[] expected = {5, 5, 5, 5, 5};

        Integer[] gnomeArr = {5, 5, 5, 5, 5};
        Integer[] cocktailArr = {5, 5, 5, 5, 5};

        SortingUtility.gnomeSort(gnomeArr);
        SortingUtility.cocktailShakerSort(cocktailArr);

        assertArrayEquals(expected, gnomeArr, "Gnome Sort failed on array with all same elements");
        assertArrayEquals(expected, cocktailArr, "Cocktail Shaker Sort failed on array with all same elements");
    }

    // --- 7. Two Elements (Swapped) ---
    @Test
    void testTwoElementsSwapped() {
        Integer[] expected = {1, 2};

        Integer[] gnomeArr = {2, 1};
        Integer[] cocktailArr = {2, 1};

        SortingUtility.gnomeSort(gnomeArr);
        SortingUtility.cocktailShakerSort(cocktailArr);

        assertArrayEquals(expected, gnomeArr, "Gnome Sort failed on two elements (swapped)");
        assertArrayEquals(expected, cocktailArr, "Cocktail Shaker Sort failed on two elements (swapped)");
    }

    // --- 8. Two Elements (Sorted) ---
    @Test
    void testTwoElementsSorted() {
        Integer[] expected = {1, 2};

        Integer[] gnomeArr = {1, 2};
        Integer[] cocktailArr = {1, 2};

        SortingUtility.gnomeSort(gnomeArr);
        SortingUtility.cocktailShakerSort(cocktailArr);

        assertArrayEquals(expected, gnomeArr, "Gnome Sort failed on two elements (already sorted)");
        assertArrayEquals(expected, cocktailArr, "Cocktail Shaker Sort failed on two elements (already sorted)");
    }

    // --- 9. Random Order ---
    @Test
    void testRandomOrder() {
        Integer[] expected = {11, 12, 22, 25, 34, 64, 90};

        Integer[] gnomeArr = {64, 34, 25, 12, 22, 11, 90};
        Integer[] cocktailArr = {64, 34, 25, 12, 22, 11, 90};

        SortingUtility.gnomeSort(gnomeArr);
        SortingUtility.cocktailShakerSort(cocktailArr);

        assertArrayEquals(expected, gnomeArr, "Gnome Sort failed on random order array");
        assertArrayEquals(expected, cocktailArr, "Cocktail Shaker Sort failed on random order array");
    }

    // --- 10. String Arrays (Generic Testing) ---
    @Test
    void testStringArrays() {
        String[] expected = {"apple", "banana", "mango", "zebra"};

        String[] gnomeArr = {"zebra", "apple", "mango", "banana"};
        String[] cocktailArr = {"zebra", "apple", "mango", "banana"};

        SortingUtility.gnomeSort(gnomeArr);
        SortingUtility.cocktailShakerSort(cocktailArr);

        assertArrayEquals(expected, gnomeArr, "Gnome Sort failed on String array");
        assertArrayEquals(expected, cocktailArr, "Cocktail Shaker Sort failed on String array");
    }
    // --- 11. Negative Numbers and Zero ---
    @Test
    void testNegativeNumbers() {
        Integer[] expected = {-10, -5, 0, 3, 8};

        Integer[] gnomeArr = {3, -5, 8, 0, -10};
        Integer[] cocktailArr = {3, -5, 8, 0, -10};

        SortingUtility.gnomeSort(gnomeArr);
        SortingUtility.cocktailShakerSort(cocktailArr);

        assertArrayEquals(expected, gnomeArr, "Gnome Sort failed with negative numbers");
        assertArrayEquals(expected, cocktailArr, "Cocktail Shaker Sort failed with negative numbers");
    }

    // --- 12. Nearly Sorted (Tests Cocktail early exit) ---
    @Test
    void testNearlySorted() {
        Integer[] expected = {1, 2, 3, 4, 5};

        // Only the last two elements are out of order
        Integer[] gnomeArr = {1, 2, 3, 5, 4};
        Integer[] cocktailArr = {1, 2, 3, 5, 4};

        SortingUtility.gnomeSort(gnomeArr);
        SortingUtility.cocktailShakerSort(cocktailArr);

        assertArrayEquals(expected, gnomeArr, "Gnome Sort failed on nearly sorted array");
        assertArrayEquals(expected, cocktailArr, "Cocktail Shaker Sort failed on nearly sorted array");
    }

    // --- 13. Min and Max Integer Values ---
    @Test
    void testMinMaxValues() {
        Integer[] expected = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE};

        Integer[] gnomeArr = {0, Integer.MAX_VALUE, -1, Integer.MIN_VALUE, 1};
        Integer[] cocktailArr = {0, Integer.MAX_VALUE, -1, Integer.MIN_VALUE, 1};

        SortingUtility.gnomeSort(gnomeArr);
        SortingUtility.cocktailShakerSort(cocktailArr);

        assertArrayEquals(expected, gnomeArr, "Gnome Sort failed on Min/Max integer values");
        assertArrayEquals(expected, cocktailArr, "Cocktail Shaker Sort failed on Min/Max integer values");
    }

    // --- 14. Null Array Exception Testing ---
    @Test
    void testNullArray() {
        // Cocktail Shaker should return safely without throwing an exception
        assertDoesNotThrow(() -> SortingUtility.cocktailShakerSort(null),
                "Cocktail Shaker Sort should safely handle null arrays");

        // Gnome Sort currently throws an NPE. We can either test FOR the exception:
        assertThrows(NullPointerException.class, () -> SortingUtility.gnomeSort(null),
                "Gnome Sort should throw NPE on null array");
    }
}