package Cinema.app.repository;

import Cinema.app.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SeatRepository extends JpaRepository<Seat,String> {
}
