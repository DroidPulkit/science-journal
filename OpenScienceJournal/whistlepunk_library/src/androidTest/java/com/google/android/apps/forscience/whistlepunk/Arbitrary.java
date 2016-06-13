package com.google.android.apps.forscience.whistlepunk;

import com.google.android.apps.forscience.javalib.Delay;
import com.google.common.collect.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("WeakerAccess")
public class Arbitrary {
    // TODO(saff): share code with Weather?
    private static Random sRandom = null;

    private static Random getRandom() {
        if (sRandom == null) {
            sRandom = new Random();
        }
        return sRandom;
    }

    public static int integer() {
        return getRandom().nextInt();
    }

    private static int integer(int n) {
        return getRandom().nextInt(n);
    }

    public static String string() {
        return memberOf("Ganymede", "Io", "Callisto", "Europa");
    }

    private static <T> T memberOf(T... items) {
        return items[integer(items.length)];
    }

    public static List<String> distinctStrings() {
        final List<String> strings = new ArrayList<>();
        int i = 0;
        do {
            strings.add(string() + (i++));
        } while (getRandom().nextInt(3) > 0);
        return strings;
    }

    public static List<String> distinctStrings(int howMany) {
        final List<String> strings = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            strings.add(string() + i);
        }
        return strings;
    }

    public static double doubleFloat() {
        return getRandom().nextDouble();
    }

    public static String stringDifferentThan(String other) {
        return stringSortingAfter(other);
    }

    public static String stringSortingAfter(String other) {
        return other + ":" + string();
    }


    public static Range<Long> longRange() {
        long a = longInteger();
        long b = longInteger();
        return Range.closed(Math.min(a, b), Math.max(a, b));
    }

    public static long longInteger() {
        return getRandom().nextLong();
    }

    public static Delay delay() {
        return Delay.seconds(integer());
    }

    public static float singleFloat() {
        return getRandom().nextFloat();
    }

    public static boolean bool() {
        return getRandom().nextBoolean();
    }
}