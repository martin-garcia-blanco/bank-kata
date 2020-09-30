package acceptance;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import bank.AccountService;
import bank.Transactions;
import org.junit.jupiter.api.Test;

public class PrintStatementFeature {

  @Test
  void be_able_to_create_multiple_transactions_and_print_the_statement() {
    String expectedOutput = "Date || Amount || Balance\n"
        + "30/09/2020 || 1000 || 1000\n"
        + "30/09/2020 || 100 || 1100\n"
        + "30/09/2020 || -500 || 600\n";

    Transactions transactions = new Transactions();
    AccountService accountService = new AccountService(transactions);
    accountService.deposit(1000);
    accountService.deposit(100);
    accountService.withdrawal(500);

    String output = accountService.printStatement();
    assertThat(output, is(expectedOutput));
  }
}
