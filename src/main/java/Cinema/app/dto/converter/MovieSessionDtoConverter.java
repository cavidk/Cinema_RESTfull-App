package Cinema.app.dto.converter;

import Cinema.app.dto.MovieSessionDto;
import Cinema.app.model.MovieSession;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoConverter {

    public MovieSessionDto convert(MovieSession from) {
        return new MovieSessionDto(
                from.getId(),
                from.getStartDate(),
                from.getMovie(),
                from.getHall(),
                from.getSeats(),
                from.getPrice()
        );
    }
}
