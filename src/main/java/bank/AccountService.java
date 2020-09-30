package bank;

import bank.date.DateGenerator;
import java.util.List;

public class AccountService {

  private final Transactions transactions;
  private final Printer printer;
  private final DateGenerator dateGenerator;

  public AccountService(Transactions transactions, Printer printer,
      DateGenerator dateGenerator) {
    this.transactions = transactions;
    this.printer = printer;
    this.dateGenerator = dateGenerator;
  }

  public void deposit(int amount) {
    String date = dateGenerator.formatDate();
    Transaction transaction = new Transaction(date, amount);
    transactions.add(transaction);
  }

  public void withdrawal(int amount) {
    String date = dateGenerator.formatDate();
    Transaction transaction = new Transaction(date, -amount);
    transactions.add(transaction);
  }

  public String printStatement() {
    List<Transaction> transactionsToPrint = transactions.getAll();
    return printer.print(transactionsToPrint);
  }
}
