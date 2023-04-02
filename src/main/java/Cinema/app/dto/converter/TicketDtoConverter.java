package Cinema.app.dto.converter;

import Cinema.app.dto.TicketDto;
import Cinema.app.model.Ticket;
import org.springframework.stereotype.Component;


@Component
public class TicketDtoConverter {
    public TicketDto convert(Ticket from) {
        return new TicketDto(from.getId(),
                from.getUser(),
                from.getSeat(),
                from.getMovieSession()
        );
    }
}
