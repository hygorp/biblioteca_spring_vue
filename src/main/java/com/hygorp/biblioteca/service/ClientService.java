package com.hygorp.biblioteca.service;

import com.hygorp.biblioteca.domain.Address;
import com.hygorp.biblioteca.domain.Client;
import com.hygorp.biblioteca.repository.AddressRepository;
import com.hygorp.biblioteca.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    public ClientService(ClientRepository clientRepository, AddressRepository addressRepository){
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
    }

    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }

    public Client findClientById(Integer id){
        Optional<Client> obj = clientRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public void insert(Client obj){
        clientRepository.save(obj);
    }

    public void delete(Integer id){
        clientRepository.deleteById(id);
    }

}
