package com.ibm.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.model.IpoDetails;

@Repository
public interface IpoDetailsRepository extends JpaRepository<IpoDetails, Long> {
	
	Page<IpoDetails> findByCompanyId(long id, PageRequest page);

	List<IpoDetails> findAllByOrderByOpenDateDesc();
	
}
