package pl.pjatk.s24286bank.s24286Bank;

import org.springframework.stereotype.Component;

@Component
public class BankingService {
    private final ClientStorage clientStorage;

    public BankingService(ClientStorage clientStorage) {
        this.clientStorage = clientStorage;
    }

    public void registerClient(String ID, double balance) {
        this.clientStorage.addClient(new Client(ID, balance));
    }

    public Transaction makeTransfer(String clientID, double value) {
        Client client = clientStorage.getClientByID(clientID);

        if (client == null) {
            System.out.println("There's no such a client!");
            return new Transaction(TransactionStatus.DECLINED, 0);
        }

        if (client.getBalance() < value) {
            return new Transaction(TransactionStatus.DECLINED, client.getBalance());
        }

        client.setBalance(client.getBalance() - value);
        return new Transaction(TransactionStatus.ACCEPTED, client.getBalance());
    }

    public Transaction depositMoney(String clientID, double value) {
        Client client = clientStorage.getClientByID(clientID);

        if (client == null) {
            System.out.println("There's no such a client!");
            return new Transaction(TransactionStatus.DECLINED, 0);
        }

        client.setBalance(client.getBalance() + value);
        return new Transaction(TransactionStatus.ACCEPTED, client.getBalance());
    }

    public Client findClient(String ID) {
        return clientStorage.getClientByID(ID);
    }
}
