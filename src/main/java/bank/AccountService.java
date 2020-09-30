package bank;

import java.util.List;

public class AccountService {

  private final Transactions transactions;
  private Printer printer;

  public AccountService(Transactions transactions, Printer printer) {
    this.transactions = transactions;
    this.printer = printer;
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
    return printer.print(transactionsToPrint);
  }
}
