package unit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


import bank.Transaction;
import bank.Transactions;
import org.junit.jupiter.api.Test;

public class TransactionsShould {

  @Test
  void be_able_to_store_transaction_items() {
    Transactions transactions = new Transactions();
    assertThat(transactions.transactions.size(), is(0));
    transactions.add(new Transaction("30/09/2020", 100));
    assertThat(transactions.transactions.size(), is(1));
  }

  @Test
  void be_able_to_store_multiple_transaction_items() {
    Transactions transactions = new Transactions();
    assertThat(transactions.transactions.size(), is(0));
    transactions.add(new Transaction("30/09/2020", 100));
    transactions.add(new Transaction("30/09/2020", -500));
    assertThat(transactions.transactions.size(), is(2));
    transactions.add(new Transaction("30/09/2020", 1000));
    assertThat(transactions.transactions.size(), is(3));
  }
}
