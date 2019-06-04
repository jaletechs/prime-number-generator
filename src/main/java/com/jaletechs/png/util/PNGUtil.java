package com.jaletechs.png.util;

import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by jaletechs on 2019-05-29.
 */
public class PNGUtil {

    /**
        This method works with the base assumption that 0 and 1 are not
        prime numbers. And also by returning the first prime numbers (2,3,5 & 7),
        all multiples of these prime numbers are eliminated. This leaves
        only numbers which are not multiples of the original or first prime
        numbers, making them prime numbers themselves.
     */

    public static boolean isPrime1(int number) {
        if (number <= 1) {
            return false;
        }

        if (number == 2 || number == 3 || number == 5 || number == 7) {
            return true;
        }

        if (number % 2 == 0) { //is an even number, hence can never be prime
            return false;
        }

        if (number % 3 == 0 || number % 5 == 0 || number % 7 == 0) { //Check against the base prime numbers
            return false;
        }

        return true;
    }


    public static boolean optimizedIsPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param start
     * @param end
     * @param range
     * @return
     */
    public static List<int []> partitions(int start, int end, int range) {
        List<Integer> list = IntStream.range(start, end)
                .boxed().collect(Collectors.toList());

        List<List<Integer>> partition = ListUtils.partition(list, range);

        return getRanges(partition);
    }

    private static List<int[]> getRanges(List<List<Integer>> partitions) {
        List<int[]> ranges = new ArrayList<>();

        partitions.forEach(partition -> {
            int [] arr = { partition.get(0), partition.get(partition.size()-1)};
            ranges.add(arr);
        });

        return ranges;
    }
}
