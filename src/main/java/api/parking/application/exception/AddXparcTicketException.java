package api.parking.application.exception;

import io.micronaut.http.HttpStatus;

public class AddXparcTicketException extends Exception{

    public AddXparcTicketException(HttpStatus status, String message) {
        super(message);
    }
}
