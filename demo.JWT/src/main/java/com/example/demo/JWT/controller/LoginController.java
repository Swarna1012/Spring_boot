package com.example.demo.JWT.controller;

import com.example.demo.JWT.common.APIResponse;
import com.example.demo.JWT.dto.EmailDetails;
import com.example.demo.JWT.dto.LoginRequestDTO;
import com.example.demo.JWT.dto.SignUpRequestDTO;
import com.example.demo.JWT.service.EmailService;
import com.example.demo.JWT.service.LoginService;
import com.example.demo.JWT.util.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<APIResponse> signUp(@Valid @RequestBody SignUpRequestDTO signUpRequestDTO){
        APIResponse apiResponse = loginService.signUp(signUpRequestDTO);
        return ResponseEntity.status(apiResponse.getStatus())
                             .body(apiResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse> login(@RequestBody LoginRequestDTO loginRequestDTO){
        APIResponse apiResponse = loginService.login(loginRequestDTO);
        return ResponseEntity.status(apiResponse.getStatus())
                .body(apiResponse);
    }

    @GetMapping("/privateApi")
    public ResponseEntity<APIResponse> privateApi(@RequestHeader(value = "authorization", defaultValue = "") String auth) throws Exception {
        APIResponse apiResponse = new APIResponse();

        jwtUtils.verify(auth);

//        String authorization = "";
//        jwtUtils.verify(authorization);

        apiResponse.setData("This is private API");
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }



}
