package com.workIndia.kazim.PasswordKeeper.repository;


import com.workIndia.kazim.PasswordKeeper.dao.PasswordKeeperDao;
import com.workIndia.kazim.PasswordKeeper.model.PasswordKeeperEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GetDataRepository {

    @Autowired
    PasswordKeeperDao passwordKeeperDao;

    public List<PasswordKeeperEntity> getUserDataList(Integer userId){

        return  passwordKeeperDao.findByUserId( userId);
    }



}
