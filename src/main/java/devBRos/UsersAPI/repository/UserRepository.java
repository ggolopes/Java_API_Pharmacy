package devBRos.UsersAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import devBRos.UsersAPI.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT u from User WHERE u.email = ?1")
    Optional<User> findByEmail(String email);
}
