package com.example.phone.Service;

import com.example.phone.Mapper.matchMapper;
import com.example.phone.dao.matchh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class matchServiceImpl implements matchService {
    @Autowired
    private matchMapper matchmapper;
    @Override
    public void addfoodopenid(matchh Match) {
        matchmapper.addliulan(Match);
    }

    @Override
    public List<matchh> selectfood(matchh Matchh) {
        return matchmapper.selectfood(Matchh);
    }

    @Override
    public List<matchh> select2(String openid) {
        return matchmapper.select2(openid);
    }
}
