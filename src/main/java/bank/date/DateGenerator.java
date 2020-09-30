package bank.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateGenerator {

  public static String formatDate() {
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    return dateFormat.format(date);
  }
}
