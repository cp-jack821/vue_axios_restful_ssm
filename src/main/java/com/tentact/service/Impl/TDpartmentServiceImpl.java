package com.tentact.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tentact.mapper.TDepartmentMapper;
import com.tentact.pojo.TDepartment;
import com.tentact.service.TDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TDpartmentServiceImpl implements TDepartmentService {

    @Autowired
    private TDepartmentMapper tDepartmentMapper;

    /**
     * 页面载入后进行查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<TDepartment> getDept(Integer pageNum, Integer pageSize) {

//        使用分页插件设置分页规则
        PageHelper.startPage(pageNum,pageSize);
//        查询到的集合
        List<TDepartment> list = tDepartmentMapper.findDept(pageNum, pageSize);
//        真的分页
        PageInfo<Object> pageInfo = new PageInfo<>();

        return list;

    }

}
