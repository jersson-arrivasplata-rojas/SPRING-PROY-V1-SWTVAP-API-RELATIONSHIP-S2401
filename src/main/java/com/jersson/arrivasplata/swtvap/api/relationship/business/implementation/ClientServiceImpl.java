package com.jersson.arrivasplata.swtvap.api.relationship.business.implementation;

import com.jersson.arrivasplata.swtvap.api.relationship.business.service.ClientService;
import com.jersson.arrivasplata.swtvap.api.relationship.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.relationship.model.Client;
import com.jersson.arrivasplata.swtvap.api.relationship.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }


    @Override
    public Flux<Client> getAllClients() {
        return Flux.fromIterable(clientRepository.findAll());
    }

    @Override
    public Mono<Client> getClientById(Long id) {
        return Mono.just(clientRepository.findById(id)
                .orElseThrow(() -> new CustomException("Client not found with id: " + id)));
    }

    @Override
    public Mono<Client> createClient(Client client) {   //Crear cliente
        if (client.getName() == null || client.getName().isEmpty()) {
            throw new CustomException("Client name is required");
        }
        return Mono.just(clientRepository.save(client));
    }

    @Override
    public Mono<Client> updateClient(Client client) { //Actualizar Cliente
        if (client.getName() == null || client.getName().isEmpty()) {
            throw new CustomException("Client name is required.");
        }
        return Mono.just(clientRepository.save(client));
    }

    @Override
    public Mono<Void> deleteClientById(Long id) { //Eliminar Cliente
        Optional<Client> client = clientRepository.findById(id);
        if (!client.isPresent()) {
            throw new CustomException("Client not found with id: " + id);
        }
        clientRepository.deleteById(id);
        return Mono.empty();
    }

    public Client getClientByName(String name){
        return clientRepository.findByName(name);
    }
}
