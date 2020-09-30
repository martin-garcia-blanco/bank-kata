package bank;

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
    return String.format("%s || %s || %s","Date", "Amount", "Balance");
  }
}
