package com.project.managementpeoplesystem.domain.repositories;

import com.project.managementpeoplesystem.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
