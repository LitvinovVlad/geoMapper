package org.example.geomapper.dao;

import org.example.geomapper.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
    boolean existsByRequest(String request);
}
//работа с бд