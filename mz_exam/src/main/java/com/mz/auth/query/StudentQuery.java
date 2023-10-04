package com.mz.auth.query;

import lombok.Data;


@Data
public class StudentQuery extends BaseQuery{


    /**
     * username 用户名
     */
    private String username;
    /**
     * email 邮件
     */
    private String email;

    private Integer type;
}
