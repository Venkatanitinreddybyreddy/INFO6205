package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import java.math.BigInteger;
import java.util.Arrays;

public class TimerTestInsertionSort {
    public static void main(String[] args) {

        InsertionSort ins = new InsertionSort();
        int arraySize = 50;

        for(int n = 0; n < 6; n++) {

            arraySize = arraySize * (int) Math.pow(2, n);

            Comparable[] ranArr = new Comparable[arraySize];

            for (int i = 0; i < ranArr.length; i++) {
                ranArr[i] = BigInteger.valueOf( (int)(Math.random()*100)).multiply(BigInteger.valueOf(arraySize));
            }

            Comparable[] sortArr = new Comparable[arraySize];
            for (int i = 0; i < ranArr.length; i++) {
                sortArr[i] = BigInteger.valueOf( (int)(Math.random()*100)).multiply(BigInteger.valueOf(arraySize));
            }
            Arrays.sort(sortArr);

            Comparable[] partArr = new Comparable[arraySize];
            for (int i = 0; i < sortArr.length / 2; i++) {
                partArr[i] = sortArr[i];
            }
            for (int i = ranArr.length / 2; i < sortArr.length; i++) {
                partArr[i] = ranArr[i];
            }

            Comparable[] reverseArr = new Comparable[arraySize];
            for (int i = sortArr.length - 1; i >= 0; i--) {
                reverseArr[sortArr.length - i - 1] = sortArr[i];
            }

            Timer timer = new Timer();

            final int zzz = 20;
            final double ranTime = timer.repeat(20, () -> zzz, t -> {
                ins.sort(ranArr, 0, ranArr.length - 1);
                return null;
            });
            final double sortTime = timer.repeat(20, () -> zzz, t -> {
                ins.sort(sortArr, 0, sortArr.length - 1);
                return null;
            });
            final double partTime = timer.repeat(20, () -> zzz, t -> {
                ins.sort(partArr, 0, partArr.length - 1);
                return null;
            });
            final double reverseTime = timer.repeat(20, () -> zzz, t -> {
                ins.sort(reverseArr, 0, reverseArr.length - 1);
                return null;
            });

            System.out.println("Loop: "+(n+1));
            System.out.println("The insertion sort time of random number group with length "+arraySize+" is "+ranTime);
            System.out.println("The insertion sort time of an ordered array of length "+arraySize+" is "+sortTime);
            System.out.println("The insertion sort time of an partially-ordered  array of length "+arraySize+" is "+partTime);
            System.out.println("The insertion sort time of an reverse-ordered  array of length "+arraySize+" is "+reverseTime);
        }

    }


}
