package api.parking.application.interfaces.in;

import api.parking.adapter.in.dto.AddXparcUserRequestDto;
import api.parking.domain.xparc.dto.XparcUserRegistryDto;

public abstract class AbstractXparcUserMapper {
    public abstract XparcUserRegistryDto mapAddUserRequestToRegistry(AddXparcUserRequestDto addXparcUserRequestDto);
}
