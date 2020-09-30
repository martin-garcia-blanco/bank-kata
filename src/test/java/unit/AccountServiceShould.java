package unit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import bank.AccountService;
import bank.Transaction;
import bank.Transactions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccountServiceShould {

  @Mock
  private Transactions transactions;
  private AccountService accountService;


  @BeforeEach
  void setUp() {
    accountService = new AccountService(transactions);
  }

  @Test
  void be_able_to_receive_an_deposit_and_store_it() {
    Transaction deposit = new Transaction("30/09/2020", 100);
    accountService.deposit(100);
    verify(transactions).add(deposit);
  }

  @Test
  void be_able_to_receive_a_withdrawal_and_store_it() {
    Transaction withdrawal = new Transaction("30/09/2020", -100);
    accountService.withdrawal(100);
    verify(transactions).add(withdrawal);
  }

  @Test
  void be_able_to_print_the_headers() {
    String expectedOutput = "Date || Amount || Balance";
    String output = accountService.printStatement();
    assertThat(output, is(expectedOutput));
  }

  @Test
  void be_able_to_add_a_deposit_and_print_headers_and_statement() {
    Transaction deposit = new Transaction("30/09/2020", 100);
    accountService.deposit(100);

    when(transactions.getAll()).thenReturn(new ArrayList<>(Collections.singletonList(deposit)));
    String expectedOutput = "Date || Amount || Balance\n"
        + "30/09/2020 || 100 || 100";
    String output = accountService.printStatement();

    assertThat(output, is(expectedOutput));

    verify(transactions).add(deposit);
    verify(transactions).getAll();
  }


}
