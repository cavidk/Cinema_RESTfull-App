package Cinema.app.dto.converter;

import Cinema.app.dto.HallDto;
import Cinema.app.model.Hall;
import org.springframework.stereotype.Component;

@Component
public class HallDtoConverter {

    public HallDto convert(Hall from) {
        return new HallDto(from.getId(),
                from.getName(),
                from.getTotalSeat()
        );
    }
}
