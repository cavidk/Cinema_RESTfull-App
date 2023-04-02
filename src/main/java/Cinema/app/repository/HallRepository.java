package Cinema.app.repository;

import Cinema.app.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<Hall,String> {
}
