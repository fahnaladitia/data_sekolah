package net.data.sekolah.repositories;

import net.data.sekolah.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email =:email")
    User getUserByEmail(@Param("email") String email);
}
