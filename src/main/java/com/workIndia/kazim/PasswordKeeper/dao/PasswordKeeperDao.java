package com.workIndia.kazim.PasswordKeeper.dao;

import com.workIndia.kazim.PasswordKeeper.model.PasswordKeeperEntity;
import com.workIndia.kazim.PasswordKeeper.model.UserDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasswordKeeperDao extends JpaRepository<PasswordKeeperEntity,Integer> {

    List<PasswordKeeperEntity> findByUserId(Integer userId);

}
