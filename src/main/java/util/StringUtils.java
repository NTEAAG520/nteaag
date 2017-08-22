package util;

public class StringUtils {
    public static boolean isEmpity(String string) {
        return null == string || string.equals(" ") || string.matches("\\s*");
    }

    public static String defaultValue(String content, String defaultValue) {
        if (isEmpity(content)) {
            return defaultValue;
        }
        return content;
    }
}
