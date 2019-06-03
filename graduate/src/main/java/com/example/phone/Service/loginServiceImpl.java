package com.example.phone.Service;

import com.example.phone.Mapper.loginMapper;
import com.example.phone.dao.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginServiceImpl implements loginService {
    @Autowired
    private loginMapper loginmapper;

    @Override
    public boolean AddUser(login Login) {
        boolean flag = false;
        try {
            loginmapper.addUser(Login);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public login SelectUser(login Login) {

        return loginmapper.SelectUser(Login);
    }

    @Override
    public String selectnickname(String openid) {
        return loginmapper.Selectnickname(openid);
    }
}
