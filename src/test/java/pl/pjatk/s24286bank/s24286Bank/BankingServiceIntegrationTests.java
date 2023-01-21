package pl.pjatk.s24286bank.s24286Bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BankingServiceIntegrationTests {
    @MockBean
    private ClientStorage clientStorage;

    @Autowired
    private BankingService bankingService;

    @Test
    void clientsBalanceShouldDecreaseAfterSuccessfulTransfer() {
        // given
        Client client = new Client("1", 2000);
        when(clientStorage.getClientByID(any())).thenReturn(client);

        // when
        bankingService.makeTransfer("1", 500);

        // then
        assertThat(client.getBalance()).isEqualTo(1500);
    }

    @Test
    void clientsBalanceShouldNotDecreaseAfterUnsuccessfulTransfer() {
        // given
        Client client = new Client("1", 2000);
        when(clientStorage.getClientByID(any())).thenReturn(client);

        // when
        bankingService.makeTransfer("1", 2100);

        // then
        assertThat(client.getBalance()).isEqualTo(2000);
    }

    @Test
    void clientsBalanceShouldIncreaseAfterSuccessfulDeposit() {
        // given
        Client client = new Client("1", 2000);
        when(clientStorage.getClientByID(any())).thenReturn(client);

        // when
        bankingService.depositMoney("1", 500);

        // then
        assertThat(client.getBalance()).isEqualTo(2500);
    }
}
