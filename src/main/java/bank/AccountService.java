package bank;

import java.util.List;

public class AccountService {

  private final Transactions transactions;

  public AccountService(Transactions transactions) {
    this.transactions = transactions;
  }

  public void deposit(int amount) {
    Transaction transaction = new Transaction("30/09/2020", amount);
    transactions.add(transaction);
  }

  public void withdrawal(int amount) {
    Transaction transaction = new Transaction("30/09/2020", -amount);
    transactions.add(transaction);
  }

  public String printStatement() {
    List<Transaction> transactionsToPrint = transactions.getAll();
    StringBuilder output = new StringBuilder(
        String.format("%s || %s || %s", "Date", "Amount", "Balance"));
    for (Transaction transaction : transactionsToPrint) {
      output.append(String
          .format("\n%s || %d || %d", transaction.getDate(), transaction.getAmount(),
              transaction.getAmount()));
    }
    return output.toString();
  }
}
