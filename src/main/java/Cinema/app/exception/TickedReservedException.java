package Cinema.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TickedReservedException extends RuntimeException {

    public TickedReservedException(String message) {
        super(message);
    }

}