package com.mz.auth.query;

import lombok.Data;

/**
 * @description: UserQuery 用来接收前台传递参数
 * @author:soulcoder 灵魂码仔
 * @email: 2579692606@qq.com
 * @date: created by 2020/8/21 22:42
 */
@Data
public class UserQuery extends BaseQuery{


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
