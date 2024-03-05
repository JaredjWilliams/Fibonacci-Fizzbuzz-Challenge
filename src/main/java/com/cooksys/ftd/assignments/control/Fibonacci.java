package com.cooksys.ftd.assignments.control;

/**
 * The Fibonacci sequence is simply and recursively defined: the first two elements are `1`, and
 * every other element is equal to the sum of its two preceding elements. For example:
 * <p>
 * [1, 1] =>
 * [1, 1, 1 + 1]  => [1, 1, 2] =>
 * [1, 1, 2, 1 + 2] => [1, 1, 2, 3] =>
 * [1, 1, 2, 3, 2 + 3] => [1, 1, 2, 3, 5] =>
 * ...etc
 */
public class Fibonacci {

    /**
     * Calculates the value in the Fibonacci sequence at a given index. For example,
     * `atIndex(0)` and `atIndex(1)` should return `1`, because the first two elements of the
     * sequence are both `1`.
     *
     * @param i the index of the element to calculate
     * @return the calculated element
     * @throws IllegalArgumentException if the given index is less than zero
     */
    public static int atIndex(int i) throws IllegalArgumentException {
        if (isNegative(i)) {
            throw new IllegalArgumentException();
        }

        return fibonacci(i + 1)[i];
    }

    /**
     * Calculates a slice of the fibonacci sequence, starting from a given start index (inclusive) and
     * ending at a given end index (exclusive).
     *
     * @param start the starting index of the slice (inclusive)
     * @param end   the ending index of the slice(exclusive)
     * @return the calculated slice as an array of int elements
     * @throws IllegalArgumentException if either the given start or end is negative, or if the
     *                                  given end is less than the given start
     */
    public static int[] slice(int start, int end) throws IllegalArgumentException {
        if (isNegative(start) || isNegative(end)) {
            throw new IllegalArgumentException();
        }

        if (isStartGreaterThanEnd(start, end)) {
            throw new IllegalArgumentException();
        }

        if (isEqual(start, end)) {
            return new int[0];
        }

        int[] slice = new int[end - start];

        for (int i = start; i < end; i++) {
            slice[i - start] = atIndex(i);
        }

        return slice;
    }

    private static boolean isEqual(int numOne, int numTwo) {
        return numTwo == numOne;
    }

    private static boolean isStartGreaterThanEnd(int start, int end) {
        return end < start;
    }

    private static boolean isNegative(int numOne) {
        return numOne < 0;
    }

    /**
     * Calculates the beginning of the fibonacci sequence, up to a given count.
     *
     * @param count the number of elements to calculate
     * @return the beginning of the fibonacci sequence, up to the given count, as an array of int elements
     * @throws IllegalArgumentException if the given count is negative
     */
    public static int[] fibonacci(int count) throws IllegalArgumentException {
        if (isNegative(count)) {
            throw new IllegalArgumentException();
        }

        if (isEqual(0, count)) {
            return new int[0];
        }

        if (isEqual(1, count)) {
            return new int[] {1};
        }

        int[] sequence = new int[count];
        int[] initialSequence = {1, 1};

        System.arraycopy(initialSequence, 0, sequence, 0, initialSequence.length);

        for (int i = 2; i < count; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }

        return sequence;


    }
}
