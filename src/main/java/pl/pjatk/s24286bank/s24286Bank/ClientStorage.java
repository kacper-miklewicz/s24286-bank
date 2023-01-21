package pl.pjatk.s24286bank.s24286Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientStorage {
    private final List<Client> clientsList = new ArrayList<Client>();

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
