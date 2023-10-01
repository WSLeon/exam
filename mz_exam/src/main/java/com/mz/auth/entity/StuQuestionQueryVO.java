package com.mz.auth.entity;

import lombok.Data;

/**
 * @description: StuQuestionQueryVO 学生考试试卷每题的记录情况
 */
@Data
public class StuQuestionQueryVO {
    //问题Id
    private Long questionId;
    private String questionTitle;//问题题目
    private String stuAnswer;//学生答案
    private String correntAnswer;//正确答案
    private Long q_typeid;//问题类型id
    private Integer grade;//问题分数
    private Integer correntScore;//正确得分
    /**
     * 选择题选项  对象
     */
    private QuestionXztOptions questionXztOptions;

}