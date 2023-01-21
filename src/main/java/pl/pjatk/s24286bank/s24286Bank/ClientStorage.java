package pl.pjatk.s24286bank.s24286Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientStorage {
    private final List<Client> clientsList = new ArrayList<Client>();

    public ClientStorage() {
        this.clientsList.add(new Client("1", "Mariusz", "Kolonko", 2000));
        this.clientsList.add(new Client("2", "Edyta", "Górniak", 5000));
        this.clientsList.add(new Client("3", "Janusz", "Maj", 7000));
    }

    public void addClient(Client client) {
        this.clientsList.add(client);
    }

    public List<Client> getClientsList() {
        return clientsList;
    }

    public Client getClientByID(String ID) {
        for (Client client : clientsList) {
            if (client.getID() == ID) {
                return client;
            }
        }

        return null;
    }
}
