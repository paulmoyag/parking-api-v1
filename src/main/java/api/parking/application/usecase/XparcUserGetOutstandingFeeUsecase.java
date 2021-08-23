package api.parking.application.usecase;

import api.parking.adapter.in.dto.XparcUserGetTotalDebtRequestDto;
import api.parking.adapter.in.dto.XparcUserGetOutstandingFeeResponseDto;
import api.parking.adapter.out.xparc.adapter.XparcUserAdapter;
import api.parking.application.exception.GetXparcUserException;

import javax.inject.Singleton;

@Singleton
public class XparcUserGetOutstandingFeeUsecase {

    private final XparcUserAdapter xparcUserAdapter;

    public XparcUserGetOutstandingFeeUsecase(XparcUserAdapter xparcUserAdapter) {
        this.xparcUserAdapter = xparcUserAdapter;
    }

    public XparcUserGetOutstandingFeeResponseDto xparcUserGetOutstandingFee(XparcUserGetTotalDebtRequestDto requestDto) throws GetXparcUserException {
        return xparcUserAdapter.xparcUserGetOutstandingFee(requestDto);
    }
}
