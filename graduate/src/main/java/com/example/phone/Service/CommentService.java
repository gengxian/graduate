package com.example.phone.Service;

import com.example.phone.dao.comment;

import java.util.List;

public interface CommentService {
     void insertcomment(String food,String commentme,String day,String nickname);
     List<comment>slectrall(String food);
}
