package com.project.usermanagementsystem.domain.repositories;

import com.project.usermanagementsystem.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOptionalByCpf(String cpf);

    Optional<User> findAllByAddressCity(String city);

    Optional<User> findAllByAddressState(String state);

}
