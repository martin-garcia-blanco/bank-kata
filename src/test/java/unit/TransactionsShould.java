package unit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


import bank.Transaction;
import bank.Transactions;
import java.util.ArrayList;
import java.util.List;
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

  @Test
  void be_able_to_store_multiple_transaction_items_and_fetch_them() {
    Transactions transactions = new Transactions();

    final Transaction firstTransaction = new Transaction("30/09/2020", 100);
    final Transaction secondTransaction = new Transaction("30/09/2020", -500);
    final Transaction thirdTransaction = new Transaction("30/09/2020", 1000);

    List<Transaction> expectedTransactions = new ArrayList<>(
        List.of(firstTransaction, secondTransaction, thirdTransaction));

    transactions.add(firstTransaction);
    transactions.add(secondTransaction);
    transactions.add(thirdTransaction);

    assertThat(transactions.getAll(), is(expectedTransactions));
  }
}
