package com.jersson.arrivasplata.swtvap.api.relationship.mapper;
import com.jersson.arrivasplata.swtvap.api.relationship.model.Provider;
import com.jersson.arrivasplata.swtvap.api.relationship.model.ProviderRequest;
import com.jersson.arrivasplata.swtvap.api.relationship.model.ProviderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProviderMapper {
    ProviderMapper INSTANCE = Mappers.getMapper(ProviderMapper.class);
   // @Mapping(target = "id", ignore = true)
    Provider providerRequestToProvider(ProviderRequest providerRequest);
    ProviderRequest providerToProviderRequest(Provider provider);
    ProviderResponse providerToProviderResponse(Provider provider);
    List<ProviderResponse> mapProvidersToResponses(List<Provider> providers);
}
