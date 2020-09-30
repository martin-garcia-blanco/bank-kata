package bank;

import java.util.ArrayList;
import java.util.List;

public class Transactions {

  private final List<Transaction> transactions;

  public Transactions() {
    this.transactions = new ArrayList<>();
  }

  public void add(Transaction transaction) {
    transactions.add(transaction);
  }

  public List<Transaction> getAll() {
    return transactions;
  }
}
