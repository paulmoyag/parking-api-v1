package api.parking.application.exception;

import io.micronaut.http.HttpStatus;

public class UpdateXparcPostPaymentUserException extends Exception{

    public UpdateXparcPostPaymentUserException(String message) {
        super(message);
    }
}
