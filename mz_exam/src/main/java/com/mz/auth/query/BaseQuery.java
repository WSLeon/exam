package com.mz.auth.query;

import lombok.Data;

/**
 * @description:
 * @author:soulcoder 灵魂码仔
 * @email: 2579692606@qq.com
 * @date: created by 2020/8/23 14:48
 */
@Data
public class BaseQuery {
    /**
     *   分页的起始页
     */
    private Long offset;
    /**
     *   每页显示条数
     */
    private Long page;
}
