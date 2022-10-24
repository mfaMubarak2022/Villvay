package com.villvay.producerservice.repo;

import com.villvay.producerservice.entity.CompanyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CompanyUserRep extends JpaRepository<CompanyUser, Integer> {

    public CompanyUser findByUserName(String userName);

    @Transactional
    @Modifying
    @Query("delete from CompanyUser u where u.userName = ?1")
    int deleteByUserName(String userName);


}
