package com.example.demo.JWT.service;

import com.example.demo.JWT.common.APIResponse;
import com.example.demo.JWT.dto.LoginRequestDTO;
import com.example.demo.JWT.dto.SignUpRequestDTO;
import com.example.demo.JWT.entity.User;
import com.example.demo.JWT.repo.UserRepository;
import com.example.demo.JWT.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    public APIResponse signUp(SignUpRequestDTO signUpRequestDTO) {
        APIResponse apiResponse = new APIResponse();

        //validation

        //dto to entity
        User userEntity = new User();
        userEntity.setName(signUpRequestDTO.getName());
        userEntity.setGender(signUpRequestDTO.getGender());
        userEntity.setActive(Boolean.TRUE);
        userEntity.setEmailId(signUpRequestDTO.getEmailId());
        userEntity.setPhoneNumber(signUpRequestDTO.getPhoneNumber());
        userEntity.setPassword(signUpRequestDTO.getPassword());

        //store entity
        userEntity = userRepository.save(userEntity);

        // generate jwt
        String token = jwtUtils.generateJwt(userEntity);

        Map<String, Object> data = new HashMap<>();
        data.put("accessToken", token);

        apiResponse.setData(data);

        return apiResponse;
    }

    public APIResponse login(LoginRequestDTO loginRequestDTO) {
        APIResponse apiResponse = new APIResponse();


        //validation

        //verify user exists with given email and password
        User user = userRepository.findOneByEmailIdIgnoreCaseAndPassword(loginRequestDTO.getEmailId(), loginRequestDTO.getPassword());

        //response
        if(user == null){
            apiResponse.setData("User login failed!");
            apiResponse.setError("Email or Password is wrong");
            return apiResponse;
        }

        // generate jwt
        String token = jwtUtils.generateJwt(user);

        Map<String, Object> data = new HashMap<>();
        data.put("accessToken", token);
        data.put("access", token);

        apiResponse.setData(data);

        return apiResponse;

    }
}
