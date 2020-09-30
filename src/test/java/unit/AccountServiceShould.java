package unit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import bank.AccountService;
import bank.Printer;
import bank.Transaction;
import bank.Transactions;
import bank.date.DateGenerator;
import java.util.ArrayList;
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
  @Mock
  private DateGenerator dateGeneratorStub;

  private AccountService accountService;
  private Printer printer;


  @BeforeEach
  void setUp() {
    printer = new Printer();
    accountService = new AccountService(transactions, printer, dateGeneratorStub);
  }

  @Test
  void be_able_to_receive_an_deposit_and_store_it() {
    when(dateGeneratorStub.formatDate()).thenReturn("25/09/2020");
    Transaction deposit = new Transaction("25/09/2020", 100);
    accountService.deposit(100);
    verify(transactions).add(deposit);
  }

  @Test
  void be_able_to_receive_a_withdrawal_and_store_it() {
    when(dateGeneratorStub.formatDate()).thenReturn("25/09/2020");
    Transaction withdrawal = new Transaction("25/09/2020", -100);
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
    when(dateGeneratorStub.formatDate()).thenReturn("25/09/2020");
    Transaction deposit = new Transaction("25/09/2020", 100);
    accountService.deposit(100);

    when(transactions.getAll()).thenReturn(new ArrayList<>(Collections.singletonList(deposit)));
    String expectedOutput = "Date || Amount || Balance\n"
        + "25/09/2020 || 100 || 100";
    String output = accountService.printStatement();

    assertThat(output, is(expectedOutput));

    verify(transactions).add(deposit);
  }

  @Test
  void be_able_to_add_multiple_deposits_and_withdrawals_and_print_headers_and_statement() {
    when(dateGeneratorStub.formatDate()).thenReturn("25/09/2020");
    Transaction firsDeposit = new Transaction("25/09/2020", 100);
    Transaction secondDeposit = new Transaction("25/09/2020", 500);
    Transaction withdrawal = new Transaction("25/09/2020", -200);
    accountService.deposit(100);
    accountService.deposit(500);
    accountService.withdrawal(200);

    when(transactions.getAll()).thenReturn(
        new ArrayList<>(List.of(firsDeposit, secondDeposit, withdrawal)));
    String expectedOutput = "Date || Amount || Balance\n"
        + "25/09/2020 || 100 || 100\n"
        + "25/09/2020 || 500 || 600\n"
        + "25/09/2020 || -200 || 400";
    String output = accountService.printStatement();

    assertThat(output, is(expectedOutput));

    verify(transactions).add(firsDeposit);
    verify(transactions).add(secondDeposit);
    verify(transactions).add(withdrawal);
  }
}
