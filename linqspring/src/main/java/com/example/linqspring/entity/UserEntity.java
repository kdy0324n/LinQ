package com.example.linqspring.entity;

import com.example.linqspring.dto.SignUpDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="userinfo")
@Table(name="userinfo")
public class UserEntity {
    @Id
    private String userId;
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userNickName;
    private String userPicture;
    private Date userBirth;
    private Timestamp userDate;
    private int userType;


    public UserEntity(SignUpDto dto){

        this.userId=dto.getUserId();
        this.userEmail=dto.getUserEmail();
        this.userPassword=dto.getUserPassword();
        this.userName=dto.getUserName();
        this.userNickName=dto.getUserNickName();
        this.userPicture=dto.getUserPicture();
        this.userBirth = dto.getUserBirth();
        this.userDate=null;
        this.userType=0;
    }
}
