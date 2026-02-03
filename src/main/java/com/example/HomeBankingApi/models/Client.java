package com.example.HomeBankingApi.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.toList;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long clientID;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy="client", fetch= FetchType.EAGER)
    Set<Account> accounts = new HashSet<>();

    public Client() {
    }
    public Set<Account> getAccounts() {
        return accounts;
}
    public void addAccounts(Account account) {
        account.setClient(this);
        accounts.add(account);
    }
    public Client( String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getClientID() {
        return clientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
