package com.workIndia.kazim.PasswordKeeper.dao;

import com.workIndia.kazim.PasswordKeeper.model.UserDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDataDao extends JpaRepository<UserDataEntity,Integer> {

    public Optional<UserDataEntity> findByUsername(String username);

}
