package com.mz.auth.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:soulcoder 灵魂码仔
 * @email: 2579692606@qq.com
 * @date: created by 2020/8/21 22:44
 */
@Data
public class PageList {
    /**
     * 总的条数
     */
    private Long total;

    /**
     * 分页数据
     */
    private List rows = new ArrayList<>();

}
