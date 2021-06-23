// =============================================================================
// Copyright/Security Notice
//
// Licensed Materials - Property of Qnamic AG
// (C) Copyright Qnamic AG 2003-2021
// All rights reserved
//
// End Copyright
// =============================================================================
package Qnamic.Helper;

import java.util.Arrays;
import java.util.Collection;

public abstract class StringUtils {

    public static final String EMPTY = "";

    private StringUtils() {

    }

    public static String defaultIfEmpty(String str, String defaultStr) {
        return StringUtils.isEmpty(str) ? defaultStr : str;
    }

    public static boolean equals(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 != null && s2 != null) {
            return s1.equals(s2);
        }
        return false;
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isBlank(String string) {
        int strLen;
        if (string == null || (strLen = string.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String string) {
        return !isBlank(string);
    }

    public static String defaultString(String str) {
        return str == null ? EMPTY : str;
    }

    public static String defaultString(String str, String defaultStr) {
        return str == null ? defaultStr : str;
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String[] split(String string, String delim) {
        if (string == null) {
            return null;
        }
        return string.split(delim);
    }

    public static String[] splitAndTrim(String string, String delim) {
        String[] array = split(string, delim);
        if (array != null) {
            array = Arrays.stream(array).map(String::trim).toArray(length -> new String[length]);
        }
        return array;
    }

    public static String toString(Collection<?> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (Object object : collection) {
            if (builder.length() != 0) {
                builder.append(", ");
            }
            builder.append(String.valueOf(object));
        }
        return builder.toString();
    }
}