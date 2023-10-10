package com.example.linqspring.service;

import com.example.linqspring.dto.ResponseDto;
import com.example.linqspring.dto.SignInDto;
import com.example.linqspring.dto.SignInResponseDTO;
import com.example.linqspring.dto.SignUpDto;
import com.example.linqspring.entity.UserEntity;
import com.example.linqspring.repository.DataJpaUserRepository;
import com.example.linqspring.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    DataJpaUserRepository dataJpaUserRepository;

    @Autowired
    TokenProvider tokenProvider;
    public ResponseDto<?>signUp(SignUpDto dto){
        String userId = dto.getUserId();
        String userPassword = dto.getUserPassword();
        String userPasswordCheck = dto.getUserPasswordCheck();




        if(!userPassword.equals(userPasswordCheck))
            return ResponseDto.setFailed("password not failse");
        UserEntity UserEntity = new UserEntity(dto);

        try{
            dataJpaUserRepository.save(UserEntity);
        }catch (Exception e){
            return ResponseDto.setFailed("Data Base Error");
        }


        return ResponseDto.setSuccess("SingUp Success!",null);
    }
    public ResponseDto<SignInResponseDTO> signIn(SignInDto dto){
        String userId = dto.getUserId();
        String userPassword = dto.getUserPassword();
        try {
            boolean existed = dataJpaUserRepository.existsByUserIdAndUserPassword(userId,userPassword);

            if(!existed)return ResponseDto.setFailed("Sign In Information does not Match");
        }catch (Exception error){
            return ResponseDto.setFailed("Database error");
        }
        UserEntity userEntity = null;
        try {
            userEntity = dataJpaUserRepository.findById(userId).get();
        }catch (Exception error){
            return ResponseDto.setFailed("Database Error");
        }
        userEntity.setUserPassword("");

        String token = tokenProvider.create(userId);
        int exprTime = 3600000;

        SignInResponseDTO signInResponseDTO = new SignInResponseDTO(token,exprTime,userEntity);
        return ResponseDto.setSuccess("Sign In Success",signInResponseDTO);
    }
}
