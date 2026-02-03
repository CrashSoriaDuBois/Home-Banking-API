package com.example.HomeBankingApi.controllers;


import com.example.HomeBankingApi.dtos.ClientDTO;
import com.example.HomeBankingApi.models.Client;
import com.example.HomeBankingApi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(value = "/api")
public class ClientController {
    @Autowired
    private ClientRepository repo;

    @RequestMapping("/clients")
    public List<ClientDTO> getClients() {
        return repo.findAll().stream().map(client -> new ClientDTO(client)).collect(toList());
    }

    @RequestMapping("/clients/{id}")
    public ClientDTO getClient(@PathVariable long id){
        return repo.findById(id).map(ClientDTO::new).orElse(null);
    }
}