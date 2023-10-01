package com.mz.auth.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:soulcoder 灵魂码仔
 * @email: 2579692606@qq.com
 * @date: created by 2020/8/21 8:57
 */
@Data
public class Role {
    /**
     * id 角色主键
     */
    private Long id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * sn 角色编号
     */
    private String sn;
    /**
     * 角色描述
     */
    private String desc;
    /**
     * 该角色对应权限
     */
    List<Permission> permissions = new ArrayList();
}
