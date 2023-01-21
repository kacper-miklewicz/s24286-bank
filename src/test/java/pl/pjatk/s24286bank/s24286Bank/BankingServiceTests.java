package pl.pjatk.s24286bank.s24286Bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class BankingServiceTests {
    @Mock
    private ClientStorage clientStorage;

    @InjectMocks
    private BankingService bankingService;

    @Test
    void transferShouldDecreaseBalanceByProperAmount() {
        // given
        Client client = new Client("1", 2000);
        when(clientStorage.getClientByID(any())).thenReturn(client);

        // when
        Transaction transaction = bankingService.makeTransfer("1", 500);

        // then
        assertThat(transaction.getBalanceAfterTransaction()).isEqualTo(1500);
    }

    @Test
    void transferShouldBeDeclinedWhenClientNotFound() {
        // given
        when(clientStorage.getClientByID(any())).thenReturn(null);

        // when
        Transaction transaction = bankingService.makeTransfer("2", 500);

        // then
        assertThat(transaction.getStatus()).isEqualTo(TransactionStatus.DECLINED);
    }

    @Test
    void transferShouldBeDeclinedWhenValueTooHigh() {
        // given
        Client client = new Client("1", 2000);
        when(clientStorage.getClientByID(any())).thenReturn(client);

        // when
        Transaction transaction = bankingService.makeTransfer("1", 2100);

        // then
        assertThat(transaction.getStatus()).isEqualTo(TransactionStatus.DECLINED);
    }

    @Test
    void depositShouldIncreaseBalanceWithProperAmount() {
        // given
        Client client = new Client("1", 2000);
        when(clientStorage.getClientByID(any())).thenReturn(client);

        // when
        Transaction transaction = bankingService.depositMoney("1", 500);

        // then
        assertThat(transaction.getBalanceAfterTransaction()).isEqualTo(2500);
    }

    @Test
    void depositShouldBeAcceptedWhenClientFound() {
        // given
        Client client = new Client("1", 2000);
        when(clientStorage.getClientByID(any())).thenReturn(client);

        // when
        Transaction transaction = bankingService.depositMoney("1", 500);

        // then
        assertThat(transaction.getStatus()).isEqualTo(TransactionStatus.ACCEPTED);
    }

    @Test
    void depositShouldBeDeclinedWhenClientFound() {
        // given
        when(clientStorage.getClientByID(any())).thenReturn(null);

        // when
        Transaction transaction = bankingService.depositMoney("1", 500);

        // then
        assertThat(transaction.getStatus()).isEqualTo(TransactionStatus.DECLINED);
    }
}
