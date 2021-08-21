package api.parking.application.exception;

import io.micronaut.http.HttpStatus;

public class AddXparcUserException extends Exception{

    public AddXparcUserException(HttpStatus status, String message) {
        super(message);
    }
}
