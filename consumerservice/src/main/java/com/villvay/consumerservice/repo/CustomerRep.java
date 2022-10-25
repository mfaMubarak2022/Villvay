package com.villvay.consumerservice.repo;

import com.villvay.consumerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRep extends JpaRepository<Customer, Integer> {

    public Customer findByCustomerId(Integer customerId);


    @Transactional
    @Modifying
    @Query("delete from Customer u where u.customerId = ?1")
    int deleteByCustomerId(Integer customerId);

    @Query("select count(*) from Customer")
    public long countByCustomerId();
}
