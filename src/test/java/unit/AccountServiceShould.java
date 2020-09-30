package unit;

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
}
