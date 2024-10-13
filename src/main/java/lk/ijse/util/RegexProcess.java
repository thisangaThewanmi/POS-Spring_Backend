package lk.ijse.util;
import java.util.regex.Pattern;

public class RegexProcess {
    public static boolean cusMatcher(String customerId) {
        String regexForUserID = "^CUS-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserID);
       boolean flag = regexPattern.matcher(customerId).matches();
        System.out.println(flag);
       return flag;
    }
    public static boolean userIdMatcher(String userId) {
        String regexForUserID = "^USER-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        return regexPattern.matcher(userId).matches();
    }

}
