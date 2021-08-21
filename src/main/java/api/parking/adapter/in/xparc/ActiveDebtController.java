package api.parking.adapter.in.xparc;

import api.parking.adapter.in.dto.XparcUpdatePostPaymentResponseDto;
import api.parking.adapter.in.dto.activeDebt.GetActiveDebtResponseDto;
import api.parking.application.exception.AddXparcTicketException;
import api.parking.application.usecase.activeDebt.UserActiveDebtFacade;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

@Controller(value = "/xparc/activeDebt")
public class ActiveDebtController {

    UserActiveDebtFacade activeDebtFacade;

    public ActiveDebtController(UserActiveDebtFacade activeDebtFacade
    ) {
        this.activeDebtFacade = activeDebtFacade;
    }

    @Get(value = "/get", produces = MediaType.APPLICATION_JSON)
    @Operation(summary = "check if there is any active debt in xparc",
            description = "Returns ok"
    )
    @ApiResponse(responseCode = "200", description = "Postpayment updated",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = XparcUpdatePostPaymentResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Bad Request")
    public HttpResponse<GetActiveDebtResponseDto> xparcUserPostPaymentUpdateRegistry(@QueryValue List<String> numberPlates) {
        GetActiveDebtResponseDto activeDebt = new GetActiveDebtResponseDto();
        try {
            activeDebt = activeDebtFacade.getActiveDebt(numberPlates);
            return HttpResponse.ok(activeDebt);
        }
        catch (AddXparcTicketException e){
            return HttpResponse.status(HttpStatus.BAD_REQUEST).body(activeDebt);
        }
    }
}