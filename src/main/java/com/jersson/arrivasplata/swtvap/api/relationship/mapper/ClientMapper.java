package com.jersson.arrivasplata.swtvap.api.relationship.mapper;

import com.jersson.arrivasplata.swtvap.api.relationship.model.Client;
import com.jersson.arrivasplata.swtvap.api.relationship.model.ClientRequest;
import com.jersson.arrivasplata.swtvap.api.relationship.model.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
   // @Mapping(target = "id", ignore = true)
    Client clientRequestToClient(ClientRequest clientRequest);
    ClientRequest clientToClientRequest(Client client);
    ClientResponse clientToClientResponse(Client client);
    List<ClientResponse> mapClientsToResponses(List<Client> clients);

}
