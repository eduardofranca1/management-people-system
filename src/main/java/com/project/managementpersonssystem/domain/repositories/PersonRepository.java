package com.project.managementpersonssystem.domain.repositories;

import com.project.managementpersonssystem.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findOptionalByCpf(String cpf);
}
