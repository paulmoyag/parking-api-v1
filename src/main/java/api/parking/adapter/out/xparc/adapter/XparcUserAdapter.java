package api.parking.adapter.out.xparc.adapter;


import api.parking.adapter.in.dto.AddPlateXparcUserRequestDto;
import api.parking.adapter.in.dto.AddPlateXparcUserResponseDto;
import api.parking.adapter.in.dto.AddXparcUserRequestDto;
import api.parking.adapter.in.dto.AddXparcUserResponseDto;
import api.parking.adapter.in.dto.DeletePlatesXparcRequestDto;
import api.parking.adapter.in.dto.DeletePlatesXparcResponseDto;
import api.parking.adapter.in.dto.XparcUpdatePostPaymentRequestDto;
import api.parking.adapter.in.dto.XparcUpdatePostPaymentResponseDto;
import api.parking.application.exception.AddXparcPlateUserException;
import api.parking.application.exception.AddXparcUserException;
import api.parking.application.exception.DeleteXparcPlatesException;
import api.parking.application.exception.GetXparcUserException;
import api.parking.application.exception.UpdateXparcPostPaymentUserException;
import api.parking.application.interfaces.in.AbstractXparcUserMapper;
import api.parking.application.interfaces.out.XparcUserPort;
import api.parking.domain.xparc.dto.NumberPlates;
import api.parking.domain.xparc.dto.UserRetrieveInformationDto;
import api.parking.domain.xparc.dto.XparcUserRegistryDto;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.http.client.netty.DefaultHttpClient;
import io.micronaut.http.uri.UriBuilder;
import io.reactivex.Flowable;

import javax.inject.Singleton;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class XparcUserAdapter implements XparcUserPort {

    private final AbstractXparcUserMapper userMapper;
    public String XPARC_HOST = System.getenv("XPARC_HOST");
    public String XPARC_USER_SERVICE_PATH = System.getenv("XPARC_USER_SERVICE_PATH");
    public String XPARC_USERNAME = System.getenv("XPARC_USERNAME");
    public String XPARC_PASSWORD = System.getenv("XPARC_PASSWORD");

    public XparcUserAdapter(AbstractXparcUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public AddXparcUserResponseDto xparcRegistryUser(AddXparcUserRequestDto userRequestDto) throws AddXparcUserException {
        URI uri = UriBuilder.of(XPARC_HOST)
                .path(XPARC_USER_SERVICE_PATH)
                .build();
        XparcUserRegistryDto registryDto = userMapper.mapAddUserRequestToRegistry(userRequestDto);
        HttpRequest<?> req = HttpRequest.PUT(uri, registryDto)
                .basicAuth(XPARC_USERNAME, XPARC_PASSWORD);

        HttpClient httpClient = new DefaultHttpClient();
        Flowable<AddXparcUserResponseDto> flowable = Flowable.fromPublisher(
                httpClient.retrieve(req, Argument.of(AddXparcUserResponseDto.class)));

        try {
            return flowable.blockingFirst();
        } catch (HttpClientResponseException e) {
            throw new AddXparcUserException(e.getResponse().getStatus(), e.getMessage());
        }
    }

    public AddPlateXparcUserResponseDto xparcAddPlateToUser(AddPlateXparcUserRequestDto userRequestDto) throws GetXparcUserException, AddXparcPlateUserException {
        UserRetrieveInformationDto getUserDto = xparcGetUser(userRequestDto.getUserId());
        List<NumberPlates> newNumberPlatesList = userRequestDto.getNumberPlates();
        List<NumberPlates> filteredList = newNumberPlatesList.stream().filter(numberPlatesNew -> getUserDto.getNumberPlates().stream().anyMatch(numberPlatesOld ->
                numberPlatesNew.getNumberPlate().equals(numberPlatesOld.getNumberPlate()) && numberPlatesNew.getCountryCode().equals(numberPlatesOld.getCountryCode())))
                .collect(Collectors.toList());
        if (!filteredList.isEmpty()) {
            throw new AddXparcPlateUserException(HttpStatus.ALREADY_IMPORTED, "This plate is already assigned to this user");
        }
        newNumberPlatesList.addAll(getUserDto.numberPlates);
        if (newNumberPlatesList.size() > 5) {
            throw new AddXparcPlateUserException(HttpStatus.FORBIDDEN, "The user can only have 5 plates associated");
        }
        getUserDto.setNumberPlates(newNumberPlatesList);
        URI uri = getUri(userRequestDto.getUserId());
        HttpRequest<?> req = HttpRequest.PATCH(uri, getUserDto)
                .basicAuth(XPARC_USERNAME, XPARC_PASSWORD);

        HttpClient httpClient = new DefaultHttpClient();
        Flowable<AddPlateXparcUserResponseDto> flowable = Flowable.fromPublisher(
                httpClient.retrieve(req, Argument.of(AddPlateXparcUserResponseDto.class)));

        try {
            return flowable.blockingFirst();
        } catch (HttpClientResponseException e) {
            throw new AddXparcPlateUserException(e.getResponse().getStatus(), e.getMessage());
        }
    }

    public XparcUpdatePostPaymentResponseDto xparcUpdatePostPayment(XparcUpdatePostPaymentRequestDto postpaymentRequestDto) throws GetXparcUserException, UpdateXparcPostPaymentUserException {
        UserRetrieveInformationDto getUserDto = xparcGetUser(postpaymentRequestDto.getUserId());
        getUserDto.setPostPaymentAllowed(postpaymentRequestDto.getPostPaymentStatus());
        URI uri = getUri(postpaymentRequestDto.getUserId());
        HttpRequest<?> req = HttpRequest.PATCH(uri, getUserDto)
                .basicAuth(XPARC_USERNAME, XPARC_PASSWORD);

        HttpClient httpClient = new DefaultHttpClient();
        Flowable<XparcUpdatePostPaymentResponseDto> flowable = Flowable.fromPublisher(
                httpClient.retrieve(req, Argument.of(XparcUpdatePostPaymentResponseDto.class)));

        try {
            return flowable.blockingFirst();
        } catch (HttpClientResponseException e) {
            throw new UpdateXparcPostPaymentUserException(e.getMessage());
        }
    }

    public UserRetrieveInformationDto xparcGetUser(String userId) throws GetXparcUserException {
        URI uri = getUri(userId);
        HttpRequest<?> req = HttpRequest.GET(uri)
                .basicAuth(XPARC_USERNAME, XPARC_PASSWORD);

        HttpClient httpClient = new DefaultHttpClient();
        Flowable<UserRetrieveInformationDto> flowable = Flowable.fromPublisher(
                httpClient.retrieve(req, Argument.of(UserRetrieveInformationDto.class)));

        try {
            return flowable.blockingFirst();
        } catch (HttpClientResponseException e) {
            throw new GetXparcUserException(e.getResponse().getStatus(), e.getMessage());
        }
    }

    public DeletePlatesXparcResponseDto xparcDeletePlate(DeletePlatesXparcRequestDto deletePlateXparcRequestDto) throws DeleteXparcPlatesException, GetXparcUserException {
        UserRetrieveInformationDto getUserDto = xparcGetUser(deletePlateXparcRequestDto.getUserId());

        List<String> platesToDelete = deletePlateXparcRequestDto.getNumberPlates();
        if(null == platesToDelete || platesToDelete.size() == 0){
            throw new DeleteXparcPlatesException("Plates to delete is null or empty");
        }
        Optional.ofNullable(getUserDto.numberPlates).map(platesList->platesList.removeIf(np->platesToDelete.contains(np.getNumberPlate())));

        URI uri = getUri(deletePlateXparcRequestDto.getUserId());
        HttpRequest<?> req = HttpRequest.PATCH(uri, getUserDto)
                .basicAuth(XPARC_USERNAME, XPARC_PASSWORD);

        try {
            HttpClient httpClient = new DefaultHttpClient();
            Flowable<DeletePlatesXparcResponseDto> flowable = Flowable.fromPublisher(
                    httpClient.retrieve(req, Argument.of(DeletePlatesXparcResponseDto.class)));

            return flowable.blockingFirst();
        } catch (HttpClientResponseException e) {
            throw new DeleteXparcPlatesException(e.getMessage());
        }
    }

    private URI getUri(String userId) {
        return UriBuilder.of(XPARC_HOST)
                .path(XPARC_USER_SERVICE_PATH)
                .path("/")
                .path(userId)
                .build();
    }
}
