package api.parking.application.usecase.activeDebt;


import api.parking.adapter.in.dto.XparcRequestTicketRequestDto;
import api.parking.adapter.in.dto.XparcRequestTicketResponseDto;
import api.parking.adapter.in.dto.activeDebt.GetActiveDebtResponseDto;
import api.parking.application.exception.AddXparcTicketException;
import api.parking.application.interfaces.out.XparcTicketPort;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class GetUserActiveDebtUsecase {
    private final XparcTicketPort xparcTicketPort;

    public GetUserActiveDebtUsecase(XparcTicketPort xparcTicketPort) {
        this.xparcTicketPort = xparcTicketPort;
    }

    public GetActiveDebtResponseDto getActiveDebt(List<String> numberplates) throws AddXparcTicketException {
        return xparcTicketPort.xparcGetActiveDebt(numberplates);
    }

    public XparcRequestTicketResponseDto xparcRequestTicket(XparcRequestTicketRequestDto requestDto) throws AddXparcTicketException{
        return xparcTicketPort.xparcRequestTicket(requestDto);
    }
}
