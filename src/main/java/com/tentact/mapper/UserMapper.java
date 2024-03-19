package com.tentact.mapper;


import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.classfile.Code;
import com.tentact.pojo.User;
import com.tentact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    //  页面载入后查询分页查询+模糊查询
    List<User> selectUsersByPageOrLike(String userName);

    // 根据ID删除
    Integer deleteUserById(String uuid);

    // 添加
    Integer insertUser(User user);

    // 修改
    Integer UpdateUser(User user);

//    查询
    User selectUserByUsername(String username);

//    验证码
    String selectCode();

//    更新
    Integer updateCode(String code);

}
