package com.example.HomeBankingApi;
import com.example.HomeBankingApi.models.*;
import com.example.HomeBankingApi.repositories.*;
import com.example.HomeBankingApi.enums.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class HomeBankingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeBankingApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository){
		return (args -> {

			Client client1 = new Client("Melba", "Morel", "melba@mindhub.com");
			Account account1 = new Account("VIN001", LocalDate.now(),5000 );
			Account account2 = new Account("VIN002", (LocalDate.now()).plusDays(1),7500 );
			Transaction transaction_1 = new Transaction(TransactionType.DEBIT,5000,"LALA", LocalDateTime.now());

			client1.addAccounts(account1);
			client1.addAccounts(account2);
			account1.addTransaction(transaction_1);

			clientRepository.save(client1);
			accountRepository.save(account1);
			accountRepository.save(account2);

			transactionRepository.save(transaction_1);

			Client client2 = new Client("Ines", "Risotto", "inessirotto@gmail.com");
			Account account3 = new Account("VIN003", LocalDate.now(),2500 );
			Account account4 = new Account("VIN004", (LocalDate.now()).plusDays(1),1000 );
			Transaction transaction_2 = new Transaction(TransactionType.CREDIT,25000,"LALA",LocalDateTime.now());

			client2.addAccounts(account3);
			client2.addAccounts(account4);
			account3.addTransaction(transaction_2);

			clientRepository.save(client2);
			accountRepository.save(account3);
			accountRepository.save(account4);

			transactionRepository.save(transaction_2);
		});
	}
}
