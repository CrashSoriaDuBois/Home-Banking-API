package com.example.HomeBankingApi;
import com.example.HomeBankingApi.models.Client;
import com.example.HomeBankingApi.repositories.ClientRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeBankingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeBankingApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository){
		return (args -> {
			Client client1 = new Client(1, "Melba", "Morel", "melba@mindhub.com");
			clientRepository.save(client1);

			clientRepository.save(new Client(2, "Ines", "Risotto", "inessirotto@gmail.com"));
		});
	}
}
