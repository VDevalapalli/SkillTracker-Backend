package com.iiht.fse4.skilltracker.auth.service;

import com.iiht.fse4.skilltracker.auth.model.AddUserResponse;
import com.iiht.fse4.skilltracker.auth.model.LoginUserResponse;
import com.iiht.fse4.skilltracker.auth.model.UserInfo;
import com.iiht.fse4.skilltracker.auth.model.ValidateUserResponse;
import org.springframework.data.util.Pair;

public interface UserInfoService {
    AddUserResponse addUser(UserInfo userInfo);

    LoginUserResponse authenticateUser(final Pair<String, String> userNamePassword);

    ValidateUserResponse validateUser(String token);
}
