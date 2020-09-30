package bank;

import java.util.List;

public class Printer {

  public String print(List<Transaction> transactions) {
    StringBuilder output = new StringBuilder(
        String.format("%s || %s || %s", "Date", "Amount", "Balance"));
    for (Transaction transaction : transactions) {
      output.append(String
          .format("\n%s || %d || %d", transaction.getDate(), transaction.getAmount(),
              transaction.getAmount()));
    }
    return output.toString();
  }

}
