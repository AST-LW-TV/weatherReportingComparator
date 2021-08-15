package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GiveDateOfCreation {

    public static String get() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }
}
