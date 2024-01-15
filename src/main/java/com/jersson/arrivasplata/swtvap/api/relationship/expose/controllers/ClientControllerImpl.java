package com.jersson.arrivasplata.swtvap.api.relationship.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.relationship.business.service.ClientService;
import com.jersson.arrivasplata.swtvap.api.relationship.expose.ClientController;
import com.jersson.arrivasplata.swtvap.api.relationship.mapper.ClientMapper;
import com.jersson.arrivasplata.swtvap.api.relationship.model.Client;
import com.jersson.arrivasplata.swtvap.api.relationship.model.ClientRequest;
import com.jersson.arrivasplata.swtvap.api.relationship.model.ClientResponse;
import com.jersson.arrivasplata.swtvap.api.relationship.util.UtilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value ="/api/clients",produces = "application/vnd.swtvap-api-clients.v1+json")
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;
    private final UtilityService utilityService;
    private final ClientMapper clientMapper;

    public ClientControllerImpl(ClientService clientService,ClientMapper clientMapper,UtilityService utilityService){
        this.clientService = clientService;
        this.clientMapper = clientMapper;
        this.utilityService = utilityService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ClientResponse> getAllClients() {
        return clientService.getAllClients()
                .map(client -> {
                    ClientResponse clientResponse = clientMapper.clientToClientResponse(client);
                    return clientResponse;
                });
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ClientResponse> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
                .map(client -> {
                    ClientResponse clientResponse = clientMapper.clientToClientResponse(client);
                    return clientResponse;
                });
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ClientResponse> createClient(ClientRequest clientRequest) {
        Client client = clientMapper.clientRequestToClient(clientRequest);

        return clientService.createClient(client)
                .map(newClient -> {
                    ClientResponse clientResponse = clientMapper.clientToClientResponse(newClient);
                    return clientResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ClientResponse> updateClient(@PathVariable Long id, @RequestBody ClientRequest clientRequest) {
        Client client = clientMapper.clientRequestToClient(clientRequest);
        client.setClientId(id);
        return clientService.updateClient(client)
                .map(updatedClient -> {
                    ClientResponse clientResponse = clientMapper.clientToClientResponse(updatedClient);
                    return clientResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteClient(@PathVariable Long id) {
        return clientService.deleteClientById(id);
    }

    @GetMapping("/doSomething") // No agregar en otros
    public Mono<ResponseEntity<String>> performUsefulOperationWithResponse() {
        utilityService.doSomething();
        return Mono.just(ResponseEntity.ok("Operation successfull"));
    }
}
