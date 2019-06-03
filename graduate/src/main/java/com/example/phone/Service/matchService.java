package com.example.phone.Service;

import com.example.phone.dao.matchh;

import java.util.List;

public interface matchService {
    void addfoodopenid(matchh Match);
    List<matchh>selectfood(matchh Matchh);
    List<matchh>select2(String openid);
}
