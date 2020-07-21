package com.workIndia.kazim.PasswordKeeper.service;


import com.workIndia.kazim.PasswordKeeper.model.GetDataResponseModel;
import com.workIndia.kazim.PasswordKeeper.model.PasswordKeeperEntity;
import com.workIndia.kazim.PasswordKeeper.repository.GetDataRepository;
import com.workIndia.kazim.PasswordKeeper.utility.EncryptionUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetDataService {

    @Autowired
    GetDataRepository getDataRepository;

    public List<GetDataResponseModel> getDataForUser(Integer userId){

        List<PasswordKeeperEntity> entities = getDataRepository.getUserDataList(userId);
        if (entities != null && !entities.isEmpty()) {
            return entities.stream()
                    .map(en -> new GetDataResponseModel(en.getWebsite(), en.getUsername(), EncryptionUtility.decrypt(en.getPassword())))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }


}
