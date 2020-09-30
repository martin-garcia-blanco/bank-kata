package bank;

import java.util.List;

public class Printer {

  private final String HEADERS = String.format("%s || %s || %s", "Date", "Amount", "Balance");

  public String print(List<Transaction> transactions) {
    return buildHeaders() + buildTransactionLines(transactions);
  }

  private String buildTransactionLines(List<Transaction> transactions) {
    int balance = 0;
    StringBuilder result = new StringBuilder();
    for (Transaction transaction : transactions) {
      balance += transaction.getAmount();
      result.append(buildTransactionLine(transaction, balance));
    }
    return result.toString();
  }

  private String buildHeaders() {
    return HEADERS;
  }

  private String buildTransactionLine(Transaction transaction, int balance) {
    return String
        .format("\n%s || %d || %d", transaction.getDate(), transaction.getAmount(),
            balance);
  }

}
