package com.workIndia.kazim.PasswordKeeper.repository;

import com.workIndia.kazim.PasswordKeeper.dao.UserDataDao;
import com.workIndia.kazim.PasswordKeeper.model.SignInRequestModel;
import com.workIndia.kazim.PasswordKeeper.model.UserDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class SignInRepository {

    @Autowired
    UserDataDao userDataDao;


    @Transactional
    public UserDataEntity checkUserExist(SignInRequestModel signInRequestModel){
        return userDataDao.findByUsername(signInRequestModel.getUsername()).orElse(null);
    }

}
