package com.eustache.auto_trader.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eustache.auto_trader.Entity.Address;

public interface AddressRepository extends JpaRepository<Address, UUID>{
    
}
