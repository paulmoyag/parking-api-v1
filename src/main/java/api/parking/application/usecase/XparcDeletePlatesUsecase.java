package api.parking.application.usecase;

import api.parking.adapter.in.dto.DeletePlatesXparcRequestDto;
import api.parking.adapter.in.dto.DeletePlatesXparcResponseDto;
import api.parking.adapter.out.xparc.adapter.XparcUserAdapter;
import api.parking.application.exception.DeleteXparcPlatesException;
import api.parking.application.exception.GetXparcUserException;

import javax.inject.Singleton;

@Singleton
public class XparcDeletePlatesUsecase {

    private final XparcUserAdapter xparcUserAdapter;

    public XparcDeletePlatesUsecase(XparcUserAdapter xparcUserAdapter) {
        this.xparcUserAdapter = xparcUserAdapter;
    }

    public DeletePlatesXparcResponseDto xparcDeletePlates(DeletePlatesXparcRequestDto deletePlateXparcRequestDto) throws DeleteXparcPlatesException, GetXparcUserException {
        return xparcUserAdapter.xparcDeletePlate(deletePlateXparcRequestDto);
    }
}
