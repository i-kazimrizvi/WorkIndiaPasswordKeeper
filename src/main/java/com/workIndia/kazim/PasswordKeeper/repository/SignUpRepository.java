package com.workIndia.kazim.PasswordKeeper.repository;


import com.workIndia.kazim.PasswordKeeper.dao.UserDataDao;
import com.workIndia.kazim.PasswordKeeper.model.UserDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SignUpRepository {


    @Autowired
    UserDataDao userDataDao;

    @Transactional
    public boolean addUserToDb(UserDataEntity userDataEntity){
        try {
            userDataDao.saveAndFlush(userDataEntity);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Transactional
    public boolean checkAccountExist(UserDataEntity userDataEntity){
        return userDataDao.findByUsername(userDataEntity.getUsername()).isPresent();
    }

}
