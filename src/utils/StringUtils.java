package utils;

public class StringUtils {

    public static boolean isEmpty(String var){
        if (var == null || var.length() == 0){
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(String var){
        return !isEmpty(var);
    }
}
