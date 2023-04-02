package Cinema.app.dto;

import Cinema.app.model.MovieSession;
import Cinema.app.model.Seat;
import Cinema.app.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {

    private String id;
    private User user;
    private Seat seat;
    private MovieSession movieSession;
}
