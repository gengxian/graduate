package com.example.phone.Service;

import com.example.phone.Mapper.CommentMapper;
import com.example.phone.dao.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public void insertcomment(String food, String commentme, String day,String nickname) {
        commentMapper.insercomment(food,commentme,day,nickname);
    }

    @Override
    public List<comment> slectrall(String food) {
        return commentMapper.selecrall(food);
    }
}
