package unit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


import bank.date.DateGenerator;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class DateGeneratorShould {

  @Test
  void be_able_to_create_string_dates_with_specific_format() {
    DateGenerator dateGenerator = new DateGenerator();
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String expectedDate= dateFormat.format(date);
    System.out.println(dateFormat);
    assertThat(dateGenerator.formatDate(), is(expectedDate));
  }
}
