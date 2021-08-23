package api.parking.application.interfaces.in;

import api.parking.adapter.in.dto.XparcRequestTicketRequestDto;
import api.parking.adapter.in.dto.XparcRequestTicketResponseDto;
import api.parking.adapter.in.dto.activeDebt.GetActiveDebtResponseDto;
import api.parking.application.exception.*;

import java.util.List;


public interface UserActiveDebtInterface {

    GetActiveDebtResponseDto getActiveDebt(List<String> numberplates) throws AddXparcTicketException;
    XparcRequestTicketResponseDto xparcRequestTicket(XparcRequestTicketRequestDto requestDto) throws AddXparcTicketException;

}
