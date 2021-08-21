package api.parking.application.usecase;

import api.parking.adapter.in.dto.AddXparcUserRequestDto;
import api.parking.adapter.in.dto.AddXparcUserResponseDto;
import api.parking.adapter.out.xparc.adapter.XparcUserAdapter;
import api.parking.application.exception.AddXparcUserException;

import javax.inject.Singleton;

@Singleton
public class XparcUserRegistryUsecase {

    private final XparcUserAdapter xparcUserAdapter;

    public XparcUserRegistryUsecase(XparcUserAdapter xparcUserAdapter) {
        this.xparcUserAdapter = xparcUserAdapter;
    }

    public AddXparcUserResponseDto xparcRegistryUser(AddXparcUserRequestDto userRequestDto) throws AddXparcUserException {
        return xparcUserAdapter.xparcRegistryUser(userRequestDto);
    }
}
