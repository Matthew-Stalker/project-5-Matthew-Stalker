package com.example.sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingUtility {

    /**
     * Sorts an array using Gnome Sort algorithm (Part A)
     * Works like a garden gnome sorting flower pots
     * @param a the array of Comparable objects to sort (modified in place)
     */
    public static <T extends Comparable<T>> void gnomeSort(T[] a) {
        // Safety check to prevent NullPointerException
        if (a == null) {
            return;
        }

        // Initialize position tracking variable exactly as specified in pseudocode
        int pos = 0;

        // Continue sorting until we reach the end of the array
        while (pos < a.length) {
            // If we are at the start of the array, or the current element is
            // greater than or equal to the previous element (sorted correctly relative to each other)
            if (pos == 0 || a[pos].compareTo(a[pos - 1]) >= 0) {
                pos = pos + 1; // Move forward
            } else {
                // Elements are out of order, swap them and step backward
                swap(a, pos, pos - 1);
                pos = pos - 1;
            }
        }
    }

    /**
     * Sorts an array using Cocktail Shaker Sort algorithm (Part B)
     * A bidirectional bubble sort that alternates direction each pass
     * @param a the array of Comparable objects to sort (modified in place)
     */
    public static <T extends Comparable<T>> void cocktailShakerSort(T[] a) {
        // Handle edge cases to prevent out-of-bounds exceptions on empty or single-element arrays
        if (a == null || a.length <= 1) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;

            // Forward pass: loop from left to right
            // Note: Bounds adjusted to a.length - 1 to prevent out-of-bounds when accessing a[i + 1]
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

            // If no swaps occurred in the forward pass, the array is sorted
            if (!swapped) {
                break;
            }

            swapped = false;

            // Backward pass: loop from right to left
            // Note: Starting at a.length - 2 to prevent out-of-bounds when accessing a[i + 1]
            for (int i = a.length - 2; i >= 0; i--) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

        } while (swapped);
    }

    /**
     * Sorts an array using Shell Sort algorithm (Part C)
     * Uses Ciura gap sequence for improved performance
     * @param a the array of Comparable objects to sort (modified in place)
     */
    public static <T extends Comparable<T>> void shellSort(T[] a) {
        // Create gaps as an ArrayList per the helpful hints
        ArrayList<Integer> gaps = new ArrayList<>(Arrays.asList(701, 301, 132, 57, 23, 10, 4, 1));

        // Exact variable name 'n' for array length
        int n = a.length;

        // Start with the largest gap and work down to a gap of 1
        for (int gap : gaps) {

            // Do a gapped insertion sort for every element in gaps
            for (int i = gap; i < n; i += 1) {

                // save a[i] in temp and make a hole at position i
                T temp = a[i];

                // Declare j outside the inner loop so it can be used for the final assignment
                int j;

                // shift earlier gap-sorted elements up until the correct location for a[i] is found
                for (j = i; (j >= gap) && (a[j - gap].compareTo(temp) > 0); j -= gap) {
                    a[j] = a[j - gap];
                }

                // put temp (the original a[i]) in its correct location
                a[j] = temp;
            }
        }
    }

    /**
     * Helper swap method
     */
    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}





