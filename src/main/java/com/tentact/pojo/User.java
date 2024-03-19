package com.tentact.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String uuid;
    private String username;
    private String password;
    private Integer delflag = 1;
}
