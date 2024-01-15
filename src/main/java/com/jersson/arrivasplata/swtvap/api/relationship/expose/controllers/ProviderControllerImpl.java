package com.jersson.arrivasplata.swtvap.api.relationship.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.relationship.business.service.ProviderService;
import com.jersson.arrivasplata.swtvap.api.relationship.expose.ProviderController;
import com.jersson.arrivasplata.swtvap.api.relationship.mapper.ProviderMapper;
import com.jersson.arrivasplata.swtvap.api.relationship.model.Provider;
import com.jersson.arrivasplata.swtvap.api.relationship.model.ProviderRequest;
import com.jersson.arrivasplata.swtvap.api.relationship.model.ProviderResponse;
import com.jersson.arrivasplata.swtvap.api.relationship.util.UtilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping(value ="/api/providers",produces = "application/vnd.swtvap-api-providers.v1+json")
public class ProviderControllerImpl implements ProviderController {
    private final ProviderService providerService;
    private final UtilityService utilityService;
    private final ProviderMapper providerMapper;

    public ProviderControllerImpl(ProviderService providerService, UtilityService utilityService, ProviderMapper providerMapper) {
        this.providerService = providerService;
        this.utilityService = utilityService;
        this.providerMapper = providerMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ProviderResponse> getAllProviders() {
        return providerService.getAllProviders()
                .map(provider -> {
                    ProviderResponse providerResponse = providerMapper.providerToProviderResponse(provider);
                    return providerResponse;
                });
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProviderResponse> getProviderById(@PathVariable Long id) {
        return providerService.getProviderById(id)
                .map(provider -> {
                    ProviderResponse providerResponse = providerMapper.providerToProviderResponse(provider);
                    return providerResponse;

                });
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProviderResponse> createProvider(ProviderRequest providerRequest) {
        Provider provider = providerMapper.providerRequestToProvider(providerRequest);

        return providerService.createProvider(provider)
                .map(newProvider -> {
                    ProviderResponse providerResponse = providerMapper.providerToProviderResponse(newProvider);
                    return providerResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProviderResponse> updateProvider(Long id, ProviderRequest providerRequest) {
        Provider provider = providerMapper.providerRequestToProvider(providerRequest);
        provider.setProviderId(id);
        return providerService.updateProvider(provider)
                .map(updatedProvider -> {
                    ProviderResponse providerResponse = providerMapper.providerToProviderResponse(updatedProvider);
                    return providerResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProvider(@PathVariable Long id) {
        return providerService.deleteProviderbyId(id);
    }

    @GetMapping("/doSomething")
    public Mono<ResponseEntity<String>> performUsefulOperationWithResponse() {
        utilityService.doSomething();
        return Mono.just(ResponseEntity.ok("Operation successfull"));
    }
}
