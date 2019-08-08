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

    public static boolean equalsIgnoreCases(String var1, String var2){
        if (StringUtils.isEmpty(var1) || StringUtils.isEmpty(var2)){
            return false;
        }else{
            return var1.toUpperCase().equals(var2.toUpperCase());
        }
    }
}
