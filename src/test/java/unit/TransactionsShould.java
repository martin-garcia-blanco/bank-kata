package unit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


import bank.Transaction;
import bank.TransactionRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TransactionsShould {

  @Test
  void be_able_to_store_multiple_transaction_items_and_fetch_them() {
    TransactionRepository transactionRepository = new TransactionRepository();

    final Transaction firstTransaction = new Transaction("30/09/2020", 100);
    final Transaction secondTransaction = new Transaction("30/09/2020", -500);
    final Transaction thirdTransaction = new Transaction("30/09/2020", 1000);

    List<Transaction> expectedTransactions = new ArrayList<>(
        List.of(firstTransaction, secondTransaction, thirdTransaction));

    transactionRepository.add(firstTransaction);
    transactionRepository.add(secondTransaction);
    transactionRepository.add(thirdTransaction);

    assertThat(transactionRepository.getAll(), is(expectedTransactions));
  }
}
