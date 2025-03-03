package com.example.prototip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Kullanıcıyı username ile bulma
    Optional<User> findByUsername(String username);

    // Kullanıcı var mı kontrol etme
    boolean existsByUsername(String username);
}
