package bank;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

  private final List<Transaction> transactions;

  public TransactionRepository() {
    this.transactions = new ArrayList<>();
  }

  public void add(Transaction transaction) {
    transactions.add(transaction);
  }

  public List<Transaction> getAll() {
    return transactions;
  }
}
