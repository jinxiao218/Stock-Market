package com.ibm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.id.ExchangeCompanyId;
import com.ibm.model.ExchangeToCompany;

@Repository
public interface ExchangeToCompanyRepository extends JpaRepository<ExchangeToCompany, ExchangeCompanyId> {

}
