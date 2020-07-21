package com.workIndia.kazim.PasswordKeeper.service;


import com.workIndia.kazim.PasswordKeeper.model.SignInRequestModel;
import com.workIndia.kazim.PasswordKeeper.model.SignInResponseModel;
import com.workIndia.kazim.PasswordKeeper.model.UserDataEntity;
import com.workIndia.kazim.PasswordKeeper.repository.SignInRepository;
import com.workIndia.kazim.PasswordKeeper.utility.Constants;
import com.workIndia.kazim.PasswordKeeper.utility.PasswordHashUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInService {

    @Autowired
    SignInRepository signInRepository;

    public SignInResponseModel validateAndSignIn(SignInRequestModel signInRequestModel) {

        if(validateData(signInRequestModel.getUsername(),signInRequestModel.getPassword())){

            UserDataEntity userDataEntity = signInRepository.checkUserExist(signInRequestModel);
            if(userDataEntity ==null){
                return new SignInResponseModel(Constants.FAILURE,-1);
            }else {
                if (PasswordHashUtility.getPasswordHasher().matches(signInRequestModel.getPassword(), userDataEntity.getPassword())) {
                    return new SignInResponseModel(Constants.SUCCESS, userDataEntity.getUserId());
                }
            }
        }
        return new SignInResponseModel(Constants.FAILURE,-1);
    }


    private boolean validateData(String username, String password) {
        if(username!=null && !username.isEmpty() && password!=null && !password.isEmpty())
            return true;

        return false;
    }
}
