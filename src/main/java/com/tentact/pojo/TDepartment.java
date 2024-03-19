package com.tentact.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDepartment {
    private String uuid;
    private String deptName;
    private String delflag;
    private Integer did;
}
