package com.example.Raiffeisen.repository;

import com.example.Raiffeisen.model.Socks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocksRepository extends CrudRepository<Socks, Long> {
}
