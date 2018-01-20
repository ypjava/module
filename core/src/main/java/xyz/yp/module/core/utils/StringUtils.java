package xyz.yp.module.core.utils;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static int string2int(String in) {
        return string2int(in, 0);
    }

    public static int string2int(String in, int defaultValue) {
        if (isBlank(in)) {
            return defaultValue;
        }
        return Integer.valueOf(in);
    }

}
