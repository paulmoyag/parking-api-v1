package api.parking.adapter.in.xparc;

import api.parking.adapter.in.dto.XparcUpdatePostPaymentRequestDto;
import api.parking.adapter.in.dto.XparcUpdatePostPaymentResponseDto;
import api.parking.application.exception.GetXparcUserException;
import api.parking.application.exception.UpdateXparcPostPaymentUserException;
import api.parking.application.interfaces.in.XparcUserInterface;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Patch;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Controller(value = "/xparc/postpayment")
public class UpdatePostPaymentController {

    XparcUserInterface xparcUserRegistryInterface;

    public UpdatePostPaymentController(XparcUserInterface xparcUserRegistryInterface
    ) {
        this.xparcUserRegistryInterface = xparcUserRegistryInterface;
    }

    @Patch(value = "/update", produces = MediaType.APPLICATION_JSON)
    @Operation(summary = "update a user postpayment value in XPARC",
            description = "Returns ok and updates postpayment value to true or false"
    )
    @ApiResponse(responseCode = "200", description = "Postpayment updated",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = XparcUpdatePostPaymentResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Bad Request")
    public HttpResponse<XparcUpdatePostPaymentResponseDto> xparcUserPostPaymentUpdateRegistry(@Body XparcUpdatePostPaymentRequestDto userRequestDto) {
        try {
            XparcUpdatePostPaymentResponseDto responseDto = xparcUserRegistryInterface.xparcUserPostPaymentUpdateRegistry(userRequestDto);
            return HttpResponse.ok(responseDto);
        }
        catch (GetXparcUserException | UpdateXparcPostPaymentUserException e){
            return HttpResponse.status(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}