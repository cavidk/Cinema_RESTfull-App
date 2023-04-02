package Cinema.app.repository;

import Cinema.app.model.MovieSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieSessionRepository extends JpaRepository<MovieSession,String> {

}
