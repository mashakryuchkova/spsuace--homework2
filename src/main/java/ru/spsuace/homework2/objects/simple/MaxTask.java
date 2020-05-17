package ru.spsuace.homework2.objects.simple;

import sun.awt.shell.ShellFolder;

import java.util.Arrays;

public class MaxTask {

    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     */
    public static int[] getMaxArray1(int[] array, int count) {
        if (array.length < count) {
            return null;
        }
        int[] NewArray = Arrays.copyOf(array, array.length);
        Arrays.sort(array);
        int[] FinalArray = new int[count];
        if (count == 0) {
            return FinalArray;
        }
        for (int i = 0; i < count; i++) {
            FinalArray[i] = array[array.length - i - 1];
        }
        return FinalArray;
    }

    public static int[] getMaxArray2(int[] array, int count) {
        if (array.length < count) {
            return null;
        }
        int[] NewArray = Arrays.copyOf(array, array.length);
        int temp = 0;
        for (int i = 0; i < NewArray.length; i++) {
            for (int k = i; k > 0; k--) {
                if (NewArray[k] > NewArray[k - 1]) {
                    temp = NewArray[k];
                    NewArray[k] = NewArray[k - 1];
                    NewArray[k - 1] = temp;
                }
            }
        }
        int[] FinalArray = new int[count];
        if (count == 0) {
            return FinalArray;
        }
        for (int i = 0; i < count; i++) {
            FinalArray[i] = NewArray[i];
        }
        return FinalArray;
    }
}