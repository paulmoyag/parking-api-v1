package api.parking.application.exception;

import io.micronaut.http.HttpStatus;

public class GetXparcUserException extends Exception{

    public GetXparcUserException(HttpStatus status, String message) {
        super(message);
    }
}

