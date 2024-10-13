package com.finalcourseproject.fleetms.parameters.services;

import com.finalcourseproject.fleetms.parameters.models.Client;
import com.finalcourseproject.fleetms.parameters.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    //Get All Clients
    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }

    //Get Client By id
    public Client findClient(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    //Delete Client
    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }

    //Update Client
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

}
