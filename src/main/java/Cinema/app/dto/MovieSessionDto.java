package Cinema.app.dto;

import Cinema.app.model.Hall;
import Cinema.app.model.Movie;
import Cinema.app.model.Seat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieSessionDto {

    private String id;
    private Date startDate;
    private Movie movie;
    private Hall hall;
    private List<Seat> seats;
    private int price;
}
