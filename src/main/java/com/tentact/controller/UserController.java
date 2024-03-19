package com.tentact.controller;


import com.github.pagehelper.PageInfo;
import com.tentact.pojo.User;
import com.tentact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping(value="/uc")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     *页面载入后查询分页查询+模糊查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/gu",method = RequestMethod.GET)
    public PageInfo<User> getUserByPageOrLike(Integer pageNum, Integer pageSize,String userName) {

        return userService.findUsersByPageOrLike(pageNum, pageSize,userName);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping(value="/ru",method=RequestMethod.DELETE)
    public String removeUserByID(String id){

        return userService.dropUserById(id);
    }

    /**
     * 添加
     * @param user
     * @return
     */
    @RequestMapping(value = "/su", method = RequestMethod.POST)
    public boolean submitUser(@RequestBody User user) {

        return userService.addOrModifyUser(user);
    }

    /**
     * 查询
     * @param map
     * @return
     */
    @RequestMapping(value="/lu",method = RequestMethod.POST)
    public String loginUser(@RequestBody Map<String,Object> map){

        return userService.selectUserByUsername(map);
    }

    /**
     * 获取验证码
     * @return
     */
    @RequestMapping(value="/sc",method = RequestMethod.GET)
    public String selectCode(){

        return userService.selectCode();
    }

}
