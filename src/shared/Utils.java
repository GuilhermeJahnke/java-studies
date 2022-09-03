package shared;

public class Utils {

    public Utils() {}

    public static boolean isEmptyParams(String parameter){
        return (parameter.isEmpty() || parameter.isBlank());
    }
}
