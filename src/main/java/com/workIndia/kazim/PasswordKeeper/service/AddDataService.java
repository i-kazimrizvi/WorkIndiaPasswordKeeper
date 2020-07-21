package com.workIndia.kazim.PasswordKeeper.service;


import com.workIndia.kazim.PasswordKeeper.model.AddDataRequestModel;
import com.workIndia.kazim.PasswordKeeper.model.PasswordKeeperEntity;
import com.workIndia.kazim.PasswordKeeper.model.ResponseAddDataModel;
import com.workIndia.kazim.PasswordKeeper.repository.AddDataRepository;
import com.workIndia.kazim.PasswordKeeper.utility.Constants;
import com.workIndia.kazim.PasswordKeeper.utility.EncryptionUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddDataService {


    @Autowired
    AddDataRepository addDataRepository;


    public ResponseAddDataModel validateAndAdd(Integer userId, AddDataRequestModel addDataRequestModel) {



        if(validate(userId,addDataRequestModel) && addDataRepository.checkUserExistById(userId)){

            PasswordKeeperEntity passwordKeeperEntity = new PasswordKeeperEntity(userId,addDataRequestModel.getWebsite()
                    ,addDataRequestModel.getUsername(), EncryptionUtility.encryptPassword(addDataRequestModel.getPassword()));
            addDataRepository.addDataToDb(passwordKeeperEntity);
            return new ResponseAddDataModel(Constants.SUCCESS);

        }
        else {
            return new ResponseAddDataModel(Constants.FAILURE);
        }

    }

    private boolean validate(Integer userId, AddDataRequestModel addDataRequestModel) {

        return userId != null && addDataRequestModel.getUsername() != null && !addDataRequestModel.getUsername().isEmpty()
                && addDataRequestModel.getPassword() != null && !addDataRequestModel.getPassword().isEmpty()
                && addDataRequestModel.getWebsite() != null && !addDataRequestModel.getWebsite().isEmpty();

    }
}
