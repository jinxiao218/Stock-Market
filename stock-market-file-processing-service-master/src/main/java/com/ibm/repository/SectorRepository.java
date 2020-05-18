package com.ibm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.model.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {

}
