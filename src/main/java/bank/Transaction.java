package bank;

public class Transaction {

  private final String date;
  private final int amount;

  public Transaction(String date, int amount) {
    this.date = date;
    this.amount = amount;
  }

  public String getDate() {
    return date;
  }

  public int getAmount() {
    return amount;
  }

  @Override
  public boolean equals(Object obj) {
    Transaction transaction = (Transaction)obj;
    return this.date.equals(transaction.date) && this.amount == transaction.amount;
  }
}
