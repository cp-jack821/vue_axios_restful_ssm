package com.tentact.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tentact.mapper.UserMapper;
import com.tentact.pojo.User;
import com.tentact.service.UserService;
import com.tentact.util.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 页面载入后查询分页查询+模糊查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<User> findUsersByPageOrLike(Integer pageNum, Integer pageSize, String userName) {

        //使用分页插件 设置分页规则
        PageHelper.startPage(pageNum, pageSize);
//        查询到的集合
        List<User> list = userMapper.selectUsersByPageOrLike(userName);
        System.out.println("list = " + list);
        //  真的分页
        PageInfo<User> userPageInfo = new PageInfo<>(list, pageSize);
        return userPageInfo;
    }

    /**
     * 根据ID删除
     *
     * @param uuid
     * @return
     */
    @Override
    public String dropUserById(String uuid) {

        Integer num = userMapper.deleteUserById(uuid);
        if (num > 0) {
            return "OK";
        }
        return "ERR";
    }

    /**
     * 添加、修改
     *
     * @param user
     * @return
     */
    @Override
    public boolean addOrModifyUser(User user) {
        Integer reNum;
        //
        if (user.getUuid() != null) {

            //  修改
            reNum = userMapper.UpdateUser(user);
        } else {
//            添加
            user.setUuid(util.uuid());
            reNum = userMapper.insertUser(user);
        }

        if (reNum > 0) {
            return true;
        }
        return false;
    }

    /**
     * 查询用户
     *
     * @param map
     * @return
     */
    @Override
    public String selectUserByUsername(Map<String, Object> map) {

        String s = userMapper.selectCode();
        if (((String) map.get("code")).toLowerCase().equals(s.toLowerCase())) {
            User user = userMapper.selectUserByUsername((String) map.get("username"));
            if (user == null) {
                return "用户名错误或不存在该用户";
            } else {
                if ((user.getPassword()).equals(map.get("password"))) {
                    return "OK";
                } else {
                    return "ERR";
                }
            }
        }else{
            return "验证码错误";
        }
    }

    /**
     *查询验证码
     * @return
     */
    @Override
    public String selectCode() {

        String code = util.code();
        userMapper.updateCode(code);
        return code;

    }

}
