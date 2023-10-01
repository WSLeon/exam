package com.mz.auth.query;

import lombok.Data;

/**
 * @description: QuestionQuery
 * 用来接收前台传递参数 questionTitle
 */
@Data
public class QuestionQuery extends BaseQuery{
    /**
     * 问题的名称
     */
    private String questionTitle;

}