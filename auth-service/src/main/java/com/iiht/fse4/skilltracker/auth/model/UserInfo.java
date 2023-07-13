package com.iiht.fse4.skilltracker.auth.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserInfo {
    private int userInfoId;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String emailId;
    private String userRole;
    private Date createdDate;
    private Date updatedDate;
}
