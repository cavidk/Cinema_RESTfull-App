package Cinema.app.repository;

import Cinema.app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
//    Optional<Role> findByuserName( Role name);
}
