package com.hygorp.biblioteca.repository;

import com.hygorp.biblioteca.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
