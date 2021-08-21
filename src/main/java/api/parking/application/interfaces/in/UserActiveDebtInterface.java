package api.parking.application.interfaces.in;

import api.parking.adapter.in.dto.activeDebt.GetActiveDebtResponseDto;
import api.parking.application.exception.*;

import java.util.List;


public interface UserActiveDebtInterface {

    GetActiveDebtResponseDto getActiveDebt(List<String> numberplates) throws AddXparcTicketException;

}
