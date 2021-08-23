package api.parking.application.interfaces.out;


import api.parking.adapter.in.dto.AddPlateXparcUserRequestDto;
import api.parking.adapter.in.dto.AddPlateXparcUserResponseDto;
import api.parking.adapter.in.dto.AddXparcUserRequestDto;
import api.parking.adapter.in.dto.AddXparcUserResponseDto;
import api.parking.adapter.in.dto.XparcUpdatePostPaymentRequestDto;
import api.parking.adapter.in.dto.XparcUpdatePostPaymentResponseDto;
import api.parking.adapter.in.dto.XparcUserGetTotalDebtRequestDto;
import api.parking.adapter.in.dto.XparcUserGetOutstandingFeeResponseDto;
import api.parking.application.exception.AddXparcPlateUserException;
import api.parking.application.exception.AddXparcUserException;
import api.parking.application.exception.GetXparcUserException;
import api.parking.application.exception.UpdateXparcPostPaymentUserException;
import api.parking.domain.xparc.dto.UserRetrieveInformationDto;

public interface XparcUserPort {

    AddXparcUserResponseDto xparcRegistryUser(AddXparcUserRequestDto userRequestDto) throws AddXparcUserException;
    AddPlateXparcUserResponseDto xparcAddPlateToUser(AddPlateXparcUserRequestDto userRequestDto) throws GetXparcUserException, AddXparcPlateUserException;
    UserRetrieveInformationDto xparcGetUser(String userId) throws GetXparcUserException;
    XparcUpdatePostPaymentResponseDto xparcUpdatePostPayment(XparcUpdatePostPaymentRequestDto postpaymentRequestDto) throws GetXparcUserException, UpdateXparcPostPaymentUserException;
    XparcUserGetOutstandingFeeResponseDto xparcUserGetOutstandingFee(XparcUserGetTotalDebtRequestDto userRequestDto) throws GetXparcUserException;
}
