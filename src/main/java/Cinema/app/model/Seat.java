package Cinema.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "seats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private int number;

    @Enumerated(value = EnumType.STRING)
    private SeatStatus seatStatus;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private MovieSession movieSession;
}
