package com.none.code.generator.core;

/**
 * @author lmly
 * @date 2021/04/16
 */
public class Utils {

    private static final char A = 'A';
    private static final char Z = 'Z';
    private static final char a = 'a';
    private static final char z = 'z';

    public static String firstCharToLowerCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= A && firstChar <= Z) {
            char[] arr = str.toCharArray();
            arr[0] += (a - z);
            return new String(arr);
        }
        return str;
    }


    public static String firstCharToUpperCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= a && firstChar <= z) {
            char[] arr = str.toCharArray();
            arr[0] -= (a - A);
            return new String(arr);
        }
        return str;
    }

    public static String toCamelCase(String str) {
        if (str.indexOf('_') == -1) {
            return str;
        }
        str = str.toLowerCase();
        char[] fromArray = str.toCharArray();
        char[] toArray = new char[fromArray.length];
        int j = 0;
        for (int i = 0; i < fromArray.length; i++) {
            if (fromArray[i] == '_') {
                i++;
                if (i < fromArray.length) {
                    toArray[j++] = Character.toUpperCase(fromArray[i]);
                }
            } else {
                toArray[j++] = fromArray[i];
            }
        }
        return new String(toArray, 0, j);
    }

}
