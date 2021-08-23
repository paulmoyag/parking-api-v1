package api.parking;

import api.parking.adapter.in.dto.XparcUserGetTotalDebtRequestDto;
import api.parking.adapter.in.dto.XparcUserGetTotalDebtResponseDto;
import api.parking.adapter.in.xparc.GetUserTotalDebtController;
import api.parking.application.interfaces.in.UserActiveDebtInterface;
import api.parking.application.interfaces.in.XparcUserInterface;
import api.parking.domain.xparc.dto.ticket.FeeDto;
import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpResponse;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

@MicronautTest
class APIParkingTest {

    @Inject
    EmbeddedApplication<?> application;
    @Inject
    private XparcUserInterface xparcUserInterface;
    @Inject
    private UserActiveDebtInterface userActiveDebtInterface;

    private static EmbeddedServer server;

    private GetUserTotalDebtController getUserTotalDebtController;

    @BeforeAll
    public static void setup() {
        server = ApplicationContext.run(EmbeddedServer.class);
    }

    @AfterAll
    public static void cleanup() {
        server.stop();
    }

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void getUserTotalDebtTestSuccess(){
        getUserTotalDebtController = new GetUserTotalDebtController(xparcUserInterface, userActiveDebtInterface);
        XparcUserGetTotalDebtRequestDto requestDto= new XparcUserGetTotalDebtRequestDto();
        requestDto.setUserId("07DBB48E6CFF49C283B");
        requestDto.setNumberplate("AB69");
        requestDto.setTicketNumber(Long.valueOf(69476492));

        HttpResponse<XparcUserGetTotalDebtResponseDto> responseDto = getUserTotalDebtController
                                                                     .XparcUserGetTotalDebt(requestDto);

        Assertions.assertTrue(responseDto.getStatus().getCode() == HttpResponse.ok().code());
        FeeDto fee = responseDto.body().getTotalDebt();
        Assertions.assertTrue(fee.getValueTicket()>=0);
    }

    @Test
    void getUserTotalDebtTestNotFound(){
        getUserTotalDebtController = new GetUserTotalDebtController(xparcUserInterface, userActiveDebtInterface);
        XparcUserGetTotalDebtRequestDto requestDto= new XparcUserGetTotalDebtRequestDto();
        requestDto.setUserId("07DBB48E6CFF49C283B");
        requestDto.setNumberplate("AB6912");
        requestDto.setTicketNumber(Long.valueOf(1000000));

        HttpResponse<XparcUserGetTotalDebtResponseDto> responseDto = getUserTotalDebtController
                .XparcUserGetTotalDebt(requestDto);

        Assertions.assertTrue(responseDto.getStatus().getCode() == HttpResponse.ok().code());
        FeeDto fee = responseDto.body().getTotalDebt();
        Assertions.assertTrue(fee.getValueTicket()==null);
    }
}
