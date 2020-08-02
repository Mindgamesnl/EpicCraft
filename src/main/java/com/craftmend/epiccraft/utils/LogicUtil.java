package com.craftmend.epiccraft.utils;

public class LogicUtil {

    public static <T> boolean contains(T value, T... values) {
        Object[] var2;
        int var3;
        int var4;
        Object v;
        if (value == null) {
            var2 = values;
            var3 = values.length;

            for(var4 = 0; var4 < var3; ++var4) {
                v = var2[var4];
                if (v == null) {
                    return true;
                }
            }
        } else {
            var2 = values;
            var3 = values.length;

            for(var4 = 0; var4 < var3; ++var4) {
                v = var2[var4];
                if (value.equals(v)) {
                    return true;
                }
            }
        }

        return false;
    }

}
