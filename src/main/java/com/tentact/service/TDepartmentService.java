package com.tentact.service;

import com.github.pagehelper.PageInfo;
import com.sun.glass.ui.Size;
import com.tentact.pojo.TDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface TDepartmentService {



// 查询部门数据
    PageInfo<TDepartment> getDept(Integer pageNum, Integer pageSize);

//
}
