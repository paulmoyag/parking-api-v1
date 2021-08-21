package api.parking.application.usecase;


import api.parking.adapter.in.dto.AddPlateXparcUserRequestDto;
import api.parking.adapter.in.dto.AddPlateXparcUserResponseDto;
import api.parking.adapter.in.dto.AddXparcUserRequestDto;
import api.parking.adapter.in.dto.AddXparcUserResponseDto;
import api.parking.adapter.in.dto.DeletePlatesXparcRequestDto;
import api.parking.adapter.in.dto.DeletePlatesXparcResponseDto;
import api.parking.adapter.in.dto.XparcUpdatePostPaymentRequestDto;
import api.parking.adapter.in.dto.XparcUpdatePostPaymentResponseDto;

import api.parking.application.exception.AddXparcPlateUserException;
import api.parking.application.exception.AddXparcUserException;
import api.parking.application.exception.DeleteXparcPlatesException;
import api.parking.application.exception.GetXparcUserException;
import api.parking.application.exception.UpdateXparcPostPaymentUserException;
import api.parking.application.interfaces.in.XparcUserInterface;

import javax.inject.Singleton;

@Singleton
public class XparcUserFacade implements XparcUserInterface {
    private final XparcUserRegistryUsecase xparcUserRegistryUsecase;
    private final XparcUserPlateUpdateUsecase xparcUserUpdateUsecase;
    private final XparcUserPostPaymentUpdateUsecase xparcUserPostPaymentUpdateUsecase;
    private final XparcDeletePlatesUsecase xparcDeletePlatesUsecase;

    public XparcUserFacade(XparcUserRegistryUsecase xparcUserRegistryUsecase, XparcUserPlateUpdateUsecase xparcUserUpdateUsecase, XparcUserPostPaymentUpdateUsecase xparcUserPostPaymentUpdateUsecase, XparcDeletePlatesUsecase xparcDeletePlatesUsecase) {
        this.xparcUserRegistryUsecase = xparcUserRegistryUsecase;
        this.xparcUserUpdateUsecase = xparcUserUpdateUsecase;
        this.xparcUserPostPaymentUpdateUsecase = xparcUserPostPaymentUpdateUsecase;
        this.xparcDeletePlatesUsecase = xparcDeletePlatesUsecase;
    }

    public AddXparcUserResponseDto xparcUserRegistry(AddXparcUserRequestDto userRequestDto) throws AddXparcUserException {
        return xparcUserRegistryUsecase.xparcRegistryUser(userRequestDto);
    }
    public AddPlateXparcUserResponseDto xparcUserPlateRegistry(AddPlateXparcUserRequestDto userRequestDto) throws GetXparcUserException, AddXparcPlateUserException {
        return xparcUserUpdateUsecase.xparcAddPlateToUser(userRequestDto);
    }
    public XparcUpdatePostPaymentResponseDto xparcUserPostPaymentUpdateRegistry(XparcUpdatePostPaymentRequestDto userRequestDto) throws GetXparcUserException, UpdateXparcPostPaymentUserException {
        return xparcUserPostPaymentUpdateUsecase.xparcUpdatePostPayment(userRequestDto);
    }

    public DeletePlatesXparcResponseDto xparcDeletePlates(DeletePlatesXparcRequestDto deletePlateXparcRequestDto) throws DeleteXparcPlatesException, GetXparcUserException {
        return xparcDeletePlatesUsecase.xparcDeletePlates(deletePlateXparcRequestDto);
    }
}
