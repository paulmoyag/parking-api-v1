package api.parking.adapter.in.xparc;


import api.parking.adapter.in.dto.AddPlateXparcUserRequestDto;
import api.parking.adapter.in.dto.AddPlateXparcUserResponseDto;
import api.parking.adapter.in.dto.AddXparcUserRequestDto;
import api.parking.adapter.in.dto.AddXparcUserResponseDto;
import api.parking.adapter.in.dto.DeletePlatesXparcRequestDto;
import api.parking.adapter.in.dto.DeletePlatesXparcResponseDto;
import api.parking.application.exception.AddXparcPlateUserException;
import api.parking.application.exception.AddXparcUserException;
import api.parking.application.exception.DeleteXparcPlatesException;
import api.parking.application.exception.GetXparcUserException;
import api.parking.application.interfaces.in.XparcUserInterface;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Patch;
import io.micronaut.http.annotation.Put;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Controller(value = "/xparc/user")
public class RegisterUserController {

    XparcUserInterface xparcUserRegistryInterface;

    public RegisterUserController(XparcUserInterface xparcUserRegistryInterface
    ) {
        this.xparcUserRegistryInterface = xparcUserRegistryInterface;
    }

    @Put(value = "/register", produces = MediaType.APPLICATION_JSON)
    @Operation(summary = "Registers a user in XPARC",
            description = "Returns ok and user number"
    )
    @ApiResponse(responseCode = "200", description = "User registered",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = AddXparcUserResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Bad Request")
    public HttpResponse<AddXparcUserResponseDto> register(@Body AddXparcUserRequestDto userRequestDto) {
        try {
            AddXparcUserResponseDto responseDto = xparcUserRegistryInterface.xparcUserRegistry(userRequestDto);
            responseDto.setEmail(userRequestDto.getEmail());
            return HttpResponse.ok(responseDto);
        }
        catch (AddXparcUserException e){
            return HttpResponse.status(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Patch(value = "/addPlate", produces = MediaType.APPLICATION_JSON)
    @Operation(summary = "Registers a plate in XPARC",
            description = "Returns ok"
    )
    @ApiResponse(responseCode = "200", description = "Plate registered",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = AddPlateXparcUserResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Bad Request")
    public HttpResponse<AddPlateXparcUserResponseDto> addPlateToXparcUser(@Body AddPlateXparcUserRequestDto userRequestDto) {
        try {
            AddPlateXparcUserResponseDto responseDto = xparcUserRegistryInterface.xparcUserPlateRegistry(userRequestDto);
            return HttpResponse.ok(responseDto);
        }
        catch (GetXparcUserException | AddXparcPlateUserException e){
            return HttpResponse.status(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Delete(value = "/plates", produces = MediaType.APPLICATION_JSON)
    @Operation(summary = "Deletes plates in XPARC",
            description = "Returns ok"
    )
    @ApiResponse(responseCode = "200", description = "Plates deleted",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = AddPlateXparcUserResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Bad Request")
    public HttpResponse<DeletePlatesXparcResponseDto> deletePlatesFromXparc(@Body DeletePlatesXparcRequestDto deletePlatesRequestDto) {
        try {
            DeletePlatesXparcResponseDto responseDto = xparcUserRegistryInterface.xparcDeletePlates(deletePlatesRequestDto);
            return HttpResponse.ok(responseDto);
        }
        catch (DeleteXparcPlatesException | GetXparcUserException e){
            return HttpResponse.status(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}