package unit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import bank.AccountService;
import bank.Transaction;
import bank.Transactions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccountServiceShould {

  @Mock
  private Transactions transactions;

  @Test
  void be_able_to_receive_an_deposit_and_store_it() {
    AccountService accountService = new AccountService(transactions);
    Transaction deposit = new Transaction("30/09/2020", 100);

    accountService.deposit(100);

    verify(transactions).add(deposit);
  }

  @Test
  void be_able_to_receive_a_withdrawal_and_store_it() {
    AccountService accountService = new AccountService(transactions);
    Transaction withdrawal = new Transaction("30/09/2020", -100);

    accountService.withdrawal(100);

    verify(transactions).add(withdrawal);
  }

  @Test
  void be_able_to_print_the_headers() {
    String expectedOutput = "Date || Amount || Balance";

    AccountService accountService = new AccountService(transactions);
    String output = accountService.printStatement();

    assertThat(output, is(expectedOutput));
  }


}
