package com.workIndia.kazim.PasswordKeeper.repository;


import com.workIndia.kazim.PasswordKeeper.dao.PasswordKeeperDao;
import com.workIndia.kazim.PasswordKeeper.dao.UserDataDao;
import com.workIndia.kazim.PasswordKeeper.model.PasswordKeeperEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddDataRepository {


    @Autowired
    UserDataDao userDataDao;


    @Autowired
    PasswordKeeperDao passwordKeeperDao;

    public boolean checkUserExistById(Integer userId) {
        return userDataDao.findById(userId).isPresent();
    }

    public void addDataToDb(PasswordKeeperEntity passwordKeeperEntity){
        passwordKeeperDao.saveAndFlush(passwordKeeperEntity);
    }

}
