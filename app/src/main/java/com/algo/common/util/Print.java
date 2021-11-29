package com.algo.common.util;

import java.text.MessageFormat;
import java.util.Arrays;

public class Print {
    public static void asArray(int[] ints) {
        System.out.println(Arrays.toString(ints));
    }
    public static void asArray(float[] floats) {
        System.out.println(Arrays.toString(floats));
    }
    public static void asArray(char[] chars) {
        System.out.println(Arrays.toString(chars));
    }
    public static void asArray(short[] shorts) {
        System.out.println(Arrays.toString(shorts));
    }
    public static void asArray(byte[] bytes) {
        System.out.println(Arrays.toString(bytes));
    }
    public static void asArray(Object[] objects) {
        System.out.println(Arrays.toString(objects));
    }

    public static void byFormat(String format, Object... objects) {
        System.out.println(MessageFormat.format(format,objects));
    }
}
