package com.example.linqspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
    private String userId;
    private String userEmail;
    private String userPassword;
    private String userPasswordCheck;
    private String userName;
    private String userNickName;
    private String userPicture;
    private Date userBirth;
    private Timestamp userDate;
    private int userType;
}
