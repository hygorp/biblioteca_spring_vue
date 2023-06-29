package com.hygorp.biblioteca.repository;

import com.hygorp.biblioteca.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
