package api.parking.application.usecase;

import api.parking.adapter.in.dto.AddPlateXparcUserRequestDto;
import api.parking.adapter.in.dto.AddPlateXparcUserResponseDto;
import api.parking.adapter.out.xparc.adapter.XparcUserAdapter;
import api.parking.application.exception.AddXparcPlateUserException;
import api.parking.application.exception.AddXparcUserException;
import api.parking.application.exception.GetXparcUserException;

import javax.inject.Singleton;

@Singleton
public class XparcUserPlateUpdateUsecase {

    private final XparcUserAdapter xparcUserAdapter;

    public XparcUserPlateUpdateUsecase(XparcUserAdapter xparcUserAdapter) {
        this.xparcUserAdapter = xparcUserAdapter;
    }

    public AddPlateXparcUserResponseDto xparcAddPlateToUser(AddPlateXparcUserRequestDto userRequestDto) throws GetXparcUserException, AddXparcPlateUserException {
        return xparcUserAdapter.xparcAddPlateToUser(userRequestDto);
    }
}
