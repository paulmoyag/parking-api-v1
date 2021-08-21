package api.parking.application.usecase.activeDebt;


import api.parking.adapter.in.dto.activeDebt.GetActiveDebtResponseDto;
import api.parking.application.exception.AddXparcTicketException;
import api.parking.application.interfaces.in.UserActiveDebtInterface;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class UserActiveDebtFacade implements UserActiveDebtInterface {
    private final GetUserActiveDebtUsecase getUserActiveDebtUsecase;

    public UserActiveDebtFacade(GetUserActiveDebtUsecase getUserActiveDebtUsecase) {
        this.getUserActiveDebtUsecase = getUserActiveDebtUsecase;

    }

    @Override
    public GetActiveDebtResponseDto getActiveDebt(List<String> numberplates) throws AddXparcTicketException {
        return getUserActiveDebtUsecase.getActiveDebt(numberplates);
    }

}
