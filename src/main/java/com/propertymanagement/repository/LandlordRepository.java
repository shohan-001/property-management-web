package com.propertymanagement.repository;

import com.propertymanagement.model.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandlordRepository extends JpaRepository<Landlord, Long> {
}
