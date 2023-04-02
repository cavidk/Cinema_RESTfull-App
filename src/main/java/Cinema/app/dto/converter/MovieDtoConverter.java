package Cinema.app.dto.converter;

import Cinema.app.dto.MovieDto;
import Cinema.app.model.Movie;
import org.springframework.stereotype.Component;


@Component
public class MovieDtoConverter {
    public MovieDto convert(Movie from) {
        return new MovieDto(from.getId(),
                from.getName(),
                from.getGenre(),
                from.getDurationMin()
        );
    }
}
