package com.villvay.consumerservice.repo;

import com.villvay.consumerservice.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CompanyRep extends JpaRepository<Company, Integer> {

    public Company findByCompanyId(int companyId);

    @Transactional
    @Modifying
    @Query("delete from Company u where u.companyId = ?1")
    int deleteByCompanyId(int companyId);

}
