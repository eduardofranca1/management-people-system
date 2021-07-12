package com.project.usermanagementsystem.domain.repositories;

import com.project.usermanagementsystem.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
