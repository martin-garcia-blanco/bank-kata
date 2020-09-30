package bank;

import java.util.List;

public class Printer {

  private final String HEADERS = String.format("%s || %s || %s", "Date", "Amount", "Balance");

  public String print(List<Transaction> transactions) {
    StringBuilder output = new StringBuilder();
    output.append(buildHeaders());
    output.append(buildTransactionLines(transactions));
    return output.toString();
  }

  private String buildTransactionLines(List<Transaction> transactions) {
    StringBuilder result = new StringBuilder();
    for (Transaction transaction : transactions) {
      result.append(buildTransactionLine(transaction));
    }
    return result.toString();
  }

  private String buildHeaders() {
    return HEADERS;
  }

  private String buildTransactionLine(Transaction transaction) {
    return String
        .format("\n%s || %d || %d", transaction.getDate(), transaction.getAmount(),
            transaction.getAmount());
  }

}
