package com.tentact.mapper;

import com.tentact.pojo.TDepartment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TDepartmentMapper {

// 查询
    List<TDepartment> findDept();


}
