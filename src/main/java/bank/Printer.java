package bank;

import java.util.List;

public class Printer {

  private final String HEADERS = String.format("%s || %s || %s", "Date", "Amount", "Balance");

  public String print(List<Transaction> transactions) {
    StringBuilder output = new StringBuilder(HEADERS);
    for (Transaction transaction : transactions) {
      output.append(buildTransactionLine(transaction));
    }
    return output.toString();
  }

  private String buildTransactionLine(Transaction transaction) {
    return String
        .format("\n%s || %d || %d", transaction.getDate(), transaction.getAmount(),
            transaction.getAmount());
  }

}
