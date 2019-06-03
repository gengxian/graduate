package com.example.phone.controller;

import com.example.phone.Service.foodAllService;
import com.example.phone.dao.fooddetail;
import com.example.phone.dao.matchh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 推荐模块，第一种：基于用户的协同过滤算法
 */
@Controller
@RequestMapping("/recommend")
public class RecommendController {
    @Autowired
    private foodAllService fas;

    /**
     * 这里是推荐用户
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/usercf")
    public Map<Integer, fooddetail> UserCF(@RequestBody Map<String, Object> map) {
        System.out.println(map.get("token"));
        String token= (String) map.get("token");
        /***
         * 这里要获取到的数值赢该要有选择的是哪种类型的算法，和对应的openid
         */
        /**
         * 这里实现基于用户的协同过滤算法
         */
        /**
         * 获取每个用户浏览过的东西
         */
        List<matchh> list = fas.selectfenzu();
        int l = list.size();
        int[][] sparseMatrix = new int[l][l];//建立用户稀疏矩 阵,用于用户相似度计算【相似度矩阵】
        Map<String, Integer> userItemLength = new HashMap<>();//存储每一个用户对应的不同物品总数  eg: A 3
        Map<String, Set<String>> itemUserCollection = new HashMap<>();//建立物品到用户的倒排表 eg: a A B
        Set<String> items = new HashSet<>();//辅助存储物品集合
        Map<String, Integer> userID = new HashMap<>();//辅助存储每一个用户的用户ID映射
        Map<Integer, String> idUser = new HashMap<>();//辅助存储每一个ID对应的用户映射
        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getOpenid()+list.get(i).getFood());
            String openid = list.get(i).getOpenid();
            //获取用户的浏览过的食物
            String st = list.get(i).getFood();
            String[] sourceStrArray = st.split(",");
            userItemLength.put(list.get(i).getOpenid(), sourceStrArray.length);//eg: A 3,既一个openid里面有多少个浏览记录总数
            userID.put(list.get(i).getOpenid(), i);//用户ID与稀疏矩阵建立对应关系
            idUser.put(i, list.get(i).getOpenid());
            //建立物品--用户倒排表
            for (int j = 0; j < sourceStrArray.length ; j++) {
                if (items.contains(sourceStrArray[j])) {//如果已经包含对应的物品--用户映射,直接添加对应的用户
                    itemUserCollection.get(sourceStrArray[j]).add(openid);
//                    System.out.println(sourceStrArray[j]);
                } else {
                    items.add(sourceStrArray[j]);
                    itemUserCollection.put(sourceStrArray[j], new HashSet<String>());//创建物品--用户倒排关系
                    itemUserCollection.get(sourceStrArray[j]).add(openid);
                }
//                System.out.println(i);
                //自此用户倒排表创建完成
            }


        }
        System.out.println(itemUserCollection.toString());
        //计算相似度矩阵【稀疏】
        Set<Map.Entry<String, Set<String>>> entrySet = itemUserCollection.entrySet();
        Iterator<Map.Entry<String, Set<String>>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Set<String> commonUsers = iterator.next().getValue();
            for (String user_u : commonUsers) {
                for (String user_v : commonUsers) {
                    if (user_u.equals(user_v)) {
                        continue;
                    }
                    sparseMatrix[userID.get(user_u)][userID.get(user_v)] += 1;//计算用户u与用户v都有正反馈的物品总数
                }
            }
        }
        System.out.println(userItemLength.toString());
        //计算用户之间的相似度【余弦相似性】
        int recommendUserId = userID.get(token);
        double max=0;
        double ma=0;
        String jilu=null;
        for (int j = 0; j < sparseMatrix.length; j++) {
            if (j != recommendUserId) {
                /**
                 * 这里计算各个相似度的值，第一个相似度的值作为最大的值，其他的计算的值跟他比较
                 */
                ma=sparseMatrix[recommendUserId][j] / Math.sqrt(userItemLength.get(idUser.get(recommendUserId)) * userItemLength.get(idUser.get(j)));
                if (max<ma){
                    max=ma;
                    jilu=idUser.get(j);
                }

                System.out.println(idUser.get(recommendUserId) + "--" + idUser.get(j) + "相似度:" + sparseMatrix[recommendUserId][j] / Math.sqrt(userItemLength.get(idUser.get(recommendUserId)) * userItemLength.get(idUser.get(j))));
            }
        }
        System.out.println("跟哪个用户的相似度最高："+jilu+"相似度最高是多少"+max);
          List<matchh>ji=fas.sele(jilu);
           Map<Integer,fooddetail> m=new HashMap<>();
          for (int h=0;h<ji.size();h++){
             fooddetail fd= (fooddetail) fas.selet(ji.get(h).getFood());
                m.put(h,fd);

          }

        return m;
    }

}
