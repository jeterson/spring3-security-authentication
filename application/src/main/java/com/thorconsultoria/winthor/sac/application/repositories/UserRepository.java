package com.thorconsultoria.winthor.sac.application.repositories;

import com.thorconsultoria.winthor.sac.application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(nativeQuery = true, value = "SELECT decrypt(senhabd, usuariobd) senhabd, usuariobd, matricula FROM PCEMPR WHERE USUARIOBD = :username")
    Optional<User> findByUsername(String username);
}
