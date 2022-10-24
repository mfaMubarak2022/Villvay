package com.villvay.consumerservice.repo;

import com.villvay.consumerservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRep extends JpaRepository<User, Integer> {

    public User findByEmailId(String emailId);

    @Transactional
    @Modifying
    @Query("delete from User u where u.emailId = ?1")
    int deleteByEmailId(String emailId);


}
