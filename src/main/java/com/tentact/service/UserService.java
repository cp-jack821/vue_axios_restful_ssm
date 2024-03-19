package com.tentact.service;

import com.github.pagehelper.PageInfo;
import com.tentact.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public interface UserService {
// 页面载入后查询分页查询+模糊查询
    PageInfo<User> findUsersByPageOrLike(Integer pageNum, Integer pageSize,String userName);

// 根据ID删除
    String dropUserById(String uuid);

//    添加
    boolean addOrModifyUser(User user);

//    查询
    String selectUserByUsername(Map<String,Object> map);

//    查询验证码
    String selectCode();

}
