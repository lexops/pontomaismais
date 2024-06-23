package xyz.lexops.pontomaismais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.lexops.pontomaismais.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
