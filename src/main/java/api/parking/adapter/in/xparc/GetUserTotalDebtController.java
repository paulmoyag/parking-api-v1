package api.parking.adapter.in.xparc;

import api.parking.adapter.in.dto.XparcRequestTicketRequestDto;
import api.parking.adapter.in.dto.XparcRequestTicketResponseDto;
import api.parking.adapter.in.dto.XparcUpdatePostPaymentResponseDto;
import api.parking.adapter.in.dto.XparcUserGetTotalDebtRequestDto;
import api.parking.adapter.in.dto.XparcUserGetOutstandingFeeResponseDto;
import api.parking.adapter.in.dto.XparcUserGetTotalDebtResponseDto;
import api.parking.application.exception.AddXparcTicketException;
import api.parking.application.exception.GetXparcUserException;
import api.parking.application.interfaces.in.UserActiveDebtInterface;
import api.parking.application.interfaces.in.XparcUserInterface;
import api.parking.domain.xparc.dto.ticket.FeeDto;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Controller(value = "/xparc/user")
public class GetUserTotalDebtController {
    private final XparcUserInterface xparcUserInterface;
    private final UserActiveDebtInterface userActiveDebtInterface;

    public GetUserTotalDebtController(XparcUserInterface xparcUserInterface,
                                      UserActiveDebtInterface userActiveDebtInterface) {
        this.xparcUserInterface = xparcUserInterface;
        this.userActiveDebtInterface = userActiveDebtInterface;
    }

    @Post(value = "/getTotalDebt", produces = MediaType.APPLICATION_JSON)
    @Operation(summary = "calculate the user's total debt",
            description = "Returns the total debt = outstanding + actual fee"
    )
    @ApiResponse(responseCode = "200", description = "Get Total Debt",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = XparcUpdatePostPaymentResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Bad Request")
    public HttpResponse<XparcUserGetTotalDebtResponseDto> XparcUserGetOutstandingFee(@Body XparcUserGetTotalDebtRequestDto userRequestDto) {
        try {
            double totalDebt = 0.0;
            FeeDto fee = new FeeDto();
            XparcUserGetTotalDebtResponseDto userTotalDebtResponseDto = new XparcUserGetTotalDebtResponseDto();
            XparcRequestTicketRequestDto ticketRequestDto = new XparcRequestTicketRequestDto();

            XparcUserGetOutstandingFeeResponseDto outstandingFeeResponseDto = xparcUserInterface.xparcUserGetOutstandingFee(userRequestDto);

            ticketRequestDto.setNumberplate(userRequestDto.getNumberplate());
            ticketRequestDto.setTicketnumber(userRequestDto.getTicketNumber());
            XparcRequestTicketResponseDto requestTicketResponseDto = userActiveDebtInterface.xparcRequestTicket(ticketRequestDto);


            if (outstandingFeeResponseDto!=null) totalDebt += outstandingFeeResponseDto.getTotalFee().value;
            if(requestTicketResponseDto!=null) totalDebt += requestTicketResponseDto.getFee().getValueTicket();

            fee.setValue(totalDebt);
            userTotalDebtResponseDto.setTotalDebt(fee);

            return HttpResponse.ok(userTotalDebtResponseDto);
        }
        catch (GetXparcUserException | AddXparcTicketException e){
            return HttpResponse.status(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
