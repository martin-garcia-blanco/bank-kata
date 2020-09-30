package bank;

import bank.date.DateGenerator;
import java.util.List;

public class AccountService {

  private final TransactionRepository transactionRepository;
  private final Printer printer;
  private final DateGenerator dateGenerator;

  public AccountService(TransactionRepository transactionRepository, Printer printer,
      DateGenerator dateGenerator) {
    this.transactionRepository = transactionRepository;
    this.printer = printer;
    this.dateGenerator = dateGenerator;
  }

  public void deposit(int amount) {
    String date = dateGenerator.formatDate();
    Transaction transaction = new Transaction(date, amount);
    transactionRepository.add(transaction);
  }

  public void withdrawal(int amount) {
    String date = dateGenerator.formatDate();
    Transaction transaction = new Transaction(date, -amount);
    transactionRepository.add(transaction);
  }

  public String printStatement() {
    List<Transaction> transactionsToPrint = transactionRepository.getAll();
    return printer.print(transactionsToPrint);
  }
}
