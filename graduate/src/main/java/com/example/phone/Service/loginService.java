package com.example.phone.Service;

import com.example.phone.dao.login;


public interface loginService {
    /**
     * 增加用户信息
     */
    boolean AddUser(login Login);

    login SelectUser(login Login);
    String selectnickname(String openid);

}
