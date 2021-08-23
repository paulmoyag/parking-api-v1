package api.parking.application.interfaces.in;

import api.parking.adapter.in.dto.AddPlateXparcUserRequestDto;
import api.parking.adapter.in.dto.AddPlateXparcUserResponseDto;
import api.parking.adapter.in.dto.AddXparcUserRequestDto;
import api.parking.adapter.in.dto.AddXparcUserResponseDto;
import api.parking.adapter.in.dto.XparcUpdatePostPaymentRequestDto;
import api.parking.adapter.in.dto.XparcUpdatePostPaymentResponseDto;
import api.parking.adapter.in.dto.DeletePlatesXparcRequestDto;
import api.parking.adapter.in.dto.DeletePlatesXparcResponseDto;
import api.parking.adapter.in.dto.XparcUserGetTotalDebtRequestDto;
import api.parking.adapter.in.dto.XparcUserGetOutstandingFeeResponseDto;
import api.parking.application.exception.AddXparcPlateUserException;
import api.parking.application.exception.AddXparcUserException;
import api.parking.application.exception.DeleteXparcPlatesException;
import api.parking.application.exception.GetXparcUserException;
import api.parking.application.exception.UpdateXparcPostPaymentUserException;


public interface XparcUserInterface {

    AddXparcUserResponseDto xparcUserRegistry(AddXparcUserRequestDto userRequestDto) throws AddXparcUserException;
    AddPlateXparcUserResponseDto xparcUserPlateRegistry(AddPlateXparcUserRequestDto userRequestDto) throws GetXparcUserException, AddXparcPlateUserException;
    XparcUpdatePostPaymentResponseDto xparcUserPostPaymentUpdateRegistry(XparcUpdatePostPaymentRequestDto userRequestDto) throws GetXparcUserException, UpdateXparcPostPaymentUserException;
    DeletePlatesXparcResponseDto xparcDeletePlates(DeletePlatesXparcRequestDto deletePlatesXparcRequestDto) throws DeleteXparcPlatesException, GetXparcUserException;
    XparcUserGetOutstandingFeeResponseDto xparcUserGetOutstandingFee(XparcUserGetTotalDebtRequestDto userRequestDto) throws GetXparcUserException;
}
