/*  UserRepository.java - REST_API_Users - Code challenge for ThinkOn
**  UserRepository class to User model/entity/ORM
**  Guilherme de Goes Oliveira Lopes
**
**  Revision History
**      Guilherme Lopes, 2024.10.10: Created
*/

package devBRos.UsersAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import devBRos.UsersAPI.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    // declare custom method to find user by email
    Optional<User> findByEmail(String email);
}
