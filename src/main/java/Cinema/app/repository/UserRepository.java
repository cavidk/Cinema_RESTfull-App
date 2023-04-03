package Cinema.app.repository;

import Cinema.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByUserName(String userName);

    Boolean existsByuserName(String userName);

    Optional<User> findByuserName(String userName);
}
