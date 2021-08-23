package api.parking.adapter.out.xparc.adapter;


import api.parking.adapter.in.dto.XparcRequestTicketRequestDto;
import api.parking.adapter.in.dto.XparcRequestTicketResponseDto;
import api.parking.adapter.in.dto.activeDebt.GetActiveDebtResponseDto;
import api.parking.application.exception.AddXparcTicketException;
import api.parking.application.interfaces.out.XparcTicketPort;
import api.parking.domain.xparc.dto.ticket.ActiveDebtResDto;
import io.micronaut.context.annotation.Value;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.http.client.netty.DefaultHttpClient;
import io.micronaut.http.uri.UriBuilder;
import io.reactivex.Flowable;

import javax.inject.Singleton;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Singleton
public class XparcTicketAdapter implements XparcTicketPort {

    public String XPARC_TICKET_HOST = System.getenv("XPARC_TICKET_HOST");
    public String XPARC_INSTALATION_ID = System.getenv("XPARC_INSTALATION_ID");
	@Value("${xparc.host1}")
    public String XPARC_TICKET_HOST2 = System.getenv("XPARC_TICKET_HOST");
    public String XPARC_REQUEST_TICKET_SERVICE_PATH = System.getenv("XPARC_REQUEST_TICKET_SERVICE_PATH");
    @Value("${xparc.service.path1}" + "${xparc.ticket.getPath}"+"${xparc.ticket.method}")
    public String XPARC_REQUEST_TICKET_SERVICE_PATH2 = System.getenv("XPARC_REQUEST_TICKET_SERVICE_PATH2");
    @Value("${xparc.username}")
    public String XPARC_USERNAME = System.getenv("XPARC_USERNAME");
    @Value("${xparc.password}")
    public String XPARC_PASSWORD = System.getenv("XPARC_PASSWORD");
    private Double totalActiveDebtValue;
    private Double totalDebtValue;

    public GetActiveDebtResponseDto xparcGetActiveDebt(List<String> numberplates) {
        GetActiveDebtResponseDto activeDebtResponseDto = new GetActiveDebtResponseDto();
        totalActiveDebtValue = null;
        numberplates.forEach(numberplate -> {
            URI uri = UriBuilder.of(XPARC_TICKET_HOST)
                    .path(XPARC_INSTALATION_ID)
                    .path(XPARC_REQUEST_TICKET_SERVICE_PATH)
                    .queryParam("numberplate", numberplate)
                    .build();
            HttpRequest<?> req = HttpRequest.GET(uri)
                    .basicAuth(XPARC_USERNAME, XPARC_PASSWORD);

            HttpClient httpClient = new DefaultHttpClient();
            Flowable<ActiveDebtResDto> flowable = Flowable.fromPublisher(
                    httpClient.retrieve(req, Argument.of(ActiveDebtResDto.class)));
            try {
                ActiveDebtResDto resDto = flowable.blockingFirst();
                if (totalActiveDebtValue == null){
                totalActiveDebtValue = 0.00;}
                totalActiveDebtValue += resDto.getFee().getValue();
            } catch (HttpClientResponseException e) {
                activeDebtResponseDto.setHasActiveDebt(false);
            }
        });
        if (totalActiveDebtValue != null) {
            activeDebtResponseDto.setDebtValue(totalActiveDebtValue);
            activeDebtResponseDto.setHasActiveDebt(true);
        }
        return activeDebtResponseDto;
    }
    
    @Override
    public XparcRequestTicketResponseDto xparcRequestTicket(XparcRequestTicketRequestDto requestDto) throws AddXparcTicketException {
        totalDebtValue = 0.0;
        XparcRequestTicketResponseDto resDto = null;

        URI uri = UriBuilder.of(XPARC_TICKET_HOST2)
                    .path(XPARC_REQUEST_TICKET_SERVICE_PATH2)
                    .queryParam("ticketnumber", requestDto.getTicketnumber() != null ? requestDto.getTicketnumber() : "")
                    .queryParam("externalcardnumber", requestDto.getExternalcardnumber() != null ? requestDto.getExternalcardnumber(): "")
                    .queryParam("numberplate", requestDto.getNumberplate()!= null ?requestDto.getNumberplate(): "")
                    .queryParam("barcode", requestDto.getBarcode()!= null ? requestDto.getNumberplate(): "")
                    .queryParam("qrtext", requestDto.getQrtext()!= null ?requestDto.getNumberplate(): "")
                    .build();

        HttpRequest<?> req = HttpRequest.GET(uri)
                .basicAuth(XPARC_USERNAME, XPARC_PASSWORD);

        HttpClient httpClient = new DefaultHttpClient();
        Flowable<XparcRequestTicketResponseDto> flowable = Flowable.fromPublisher(
                httpClient.retrieve(req, Argument.of(XparcRequestTicketResponseDto.class)));
        try {
            resDto = flowable.blockingFirst();
            totalDebtValue += resDto.getFee().getValueTicket();
        } catch (HttpClientResponseException e) {
        }
        return resDto;
    }
}
