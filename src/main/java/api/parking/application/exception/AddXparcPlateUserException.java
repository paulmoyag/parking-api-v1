package api.parking.application.exception;

import io.micronaut.http.HttpStatus;

public class AddXparcPlateUserException extends Exception{

    public AddXparcPlateUserException(HttpStatus status, String message) {
        super(message);
    }
}
