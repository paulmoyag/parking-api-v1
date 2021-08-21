package api.parking.application.usecase;

import api.parking.adapter.in.dto.XparcUpdatePostPaymentRequestDto;
import api.parking.adapter.in.dto.XparcUpdatePostPaymentResponseDto;
import api.parking.adapter.out.xparc.adapter.XparcUserAdapter;
import api.parking.application.exception.AddXparcPlateUserException;
import api.parking.application.exception.AddXparcUserException;
import api.parking.application.exception.GetXparcUserException;
import api.parking.application.exception.UpdateXparcPostPaymentUserException;

import javax.inject.Singleton;

@Singleton
public class XparcUserPostPaymentUpdateUsecase {

    private final XparcUserAdapter xparcUserAdapter;

    public XparcUserPostPaymentUpdateUsecase(XparcUserAdapter xparcUserAdapter) {
        this.xparcUserAdapter = xparcUserAdapter;
    }

    public XparcUpdatePostPaymentResponseDto xparcUpdatePostPayment(XparcUpdatePostPaymentRequestDto userRequestDto) throws GetXparcUserException, UpdateXparcPostPaymentUserException {
        return xparcUserAdapter.xparcUpdatePostPayment(userRequestDto);
    }


}
