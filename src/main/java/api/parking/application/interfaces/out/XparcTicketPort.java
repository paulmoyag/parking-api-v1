package api.parking.application.interfaces.out;
import api.parking.adapter.in.dto.activeDebt.GetActiveDebtResponseDto;
import api.parking.application.exception.AddXparcTicketException;

import java.util.List;

public interface XparcTicketPort {

    GetActiveDebtResponseDto xparcGetActiveDebt(List<String> numberplates) throws AddXparcTicketException;
}
