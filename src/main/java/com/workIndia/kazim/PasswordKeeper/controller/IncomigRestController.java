package com.workIndia.kazim.PasswordKeeper.controller;


import com.workIndia.kazim.PasswordKeeper.model.AddDataRequestModel;
import com.workIndia.kazim.PasswordKeeper.model.SignInRequestModel;
import com.workIndia.kazim.PasswordKeeper.model.UserDataEntity;
import com.workIndia.kazim.PasswordKeeper.service.AddDataService;
import com.workIndia.kazim.PasswordKeeper.service.GetDataService;
import com.workIndia.kazim.PasswordKeeper.service.SignInService;
import com.workIndia.kazim.PasswordKeeper.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IncomigRestController {

    @Autowired
    SignUpService signUpService;

    @Autowired
    SignInService signInService;

    @Autowired
    AddDataService addDataService;

    @Autowired
    GetDataService getDataService;


    @PostMapping(value = "/app/user")
    public ResponseEntity signUpRequest(@RequestBody UserDataEntity userDataEntity){
        return ResponseEntity.ok().body(signUpService.validateAndSignUp(userDataEntity));
    }


    @PostMapping(value = "/app/user/auth")
    public ResponseEntity signInRequest(@RequestBody SignInRequestModel signInRequestModel){
        return ResponseEntity.ok().body(signInService.validateAndSignIn(signInRequestModel));
    }


    @PostMapping(value = "/app/sites")
    public ResponseEntity AddPasswordToAccount(@RequestParam("user") Integer userId, @RequestBody AddDataRequestModel addDataRequestModel){
            return ResponseEntity.ok().body(addDataService.validateAndAdd(userId, addDataRequestModel));
    }

    @GetMapping(value = "/app/sites/list")
    public ResponseEntity signInRequest(@RequestParam("user") Integer userId ){
        return ResponseEntity.ok().body(getDataService.getDataForUser(userId));
    }


}
