package com.tentact.controller;

import com.github.pagehelper.PageInfo;
import com.tentact.pojo.TDepartment;
import com.tentact.service.TDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/tdc")
public class TDepartmentController {

    @Autowired
    private TDepartmentService tDepartmentService;


    /**
     *查询
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/sd",method = RequestMethod.GET)
    public PageInfo<TDepartment> selectDeptByPage(Integer pageSize, Integer pageNum){

        return tDepartmentService.getDept(pageSize,pageNum);

    }


}
