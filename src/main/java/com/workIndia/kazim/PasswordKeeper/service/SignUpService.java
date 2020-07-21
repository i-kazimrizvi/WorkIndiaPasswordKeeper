package com.workIndia.kazim.PasswordKeeper.service;


import com.workIndia.kazim.PasswordKeeper.model.UserDataEntity;
import com.workIndia.kazim.PasswordKeeper.model.SignUpResponseModel;
import com.workIndia.kazim.PasswordKeeper.repository.SignUpRepository;
import com.workIndia.kazim.PasswordKeeper.utility.Constants;
import com.workIndia.kazim.PasswordKeeper.utility.PasswordHashUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    @Autowired
    SignUpRepository signUpRepository;

    public SignUpResponseModel validateAndSignUp(UserDataEntity userDataEntity){



        if(validateData(userDataEntity.getUsername(), userDataEntity.getPassword())){

            if(signUpRepository.checkAccountExist(userDataEntity)){
                return new SignUpResponseModel(Constants.SIGNUP_ACCOUNT_EXISTS);
            }
            userDataEntity.setPassword(PasswordHashUtility.getPasswordHasher().encode(userDataEntity.getPassword()));
            signUpRepository.addUserToDb(userDataEntity);
            return new SignUpResponseModel(Constants.SIGNUP_ACCOUNT_CREATED);

        }
        else {
            return new SignUpResponseModel(Constants.SIGNUP_ACCOUNT_INCORRECT_VALUES);
        }
    }

    private boolean validateData(String username, String password) {
        if(username!=null && !username.isEmpty() && password!=null && !password.isEmpty())
            return true;

        return false;
    }

}
