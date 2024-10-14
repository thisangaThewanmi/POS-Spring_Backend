package lk.ijse.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateCustomerId(){
        return "CUS-"+UUID.randomUUID();
    }

    public static String generateItemId(){
        return "ITEM-"+UUID.randomUUID();
    }


}
