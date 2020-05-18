package com.ibm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.model.FileRecord;

@Repository
public interface FileRecordRepository extends JpaRepository<FileRecord, Long> {
	Page<FileRecord> findByStateIs(int state, Pageable pageable);
}
