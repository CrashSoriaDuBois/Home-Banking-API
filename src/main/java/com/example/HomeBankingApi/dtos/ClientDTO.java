package com.example.HomeBankingApi.dtos;
import com.example.HomeBankingApi.models.Client;

import java.util.Set;
import java.util.stream.Collectors;
public class ClientDTO {
    public long id;
    public String firstName;
    public String lastName;
    public String email;
    public Set<AccountDTO> accounts;

    public ClientDTO() {
    }
    public ClientDTO(Client client) {
        this.id = client.getClientID();

        this.firstName = client.getFirstName();

        this.lastName = client.getLastName();

        this.email = client.getEmail();

        this.accounts = client.getAccounts().stream().map(AccountDTO::new).collect(Collectors.toSet());
    }
}
