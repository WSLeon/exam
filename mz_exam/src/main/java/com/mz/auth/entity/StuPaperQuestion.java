package com.mz.auth.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 学生试卷问题查询结果对象--回顾试卷  用来查看明细  有三部分：试卷id  试卷名称  试卷问题集合对象（对象有具体每题的信息）
 */
@Data
public class StuPaperQuestion {
    private Long id;//试卷id
    private String name;//试卷名称
    /*
     * 问题集合列表 对象
     * */
    private List<StuQuestionQueryVO> stuQuestionsList = new ArrayList();
}