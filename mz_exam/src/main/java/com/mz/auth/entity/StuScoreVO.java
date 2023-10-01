package com.mz.auth.entity;

import lombok.Data;

/**
 * @description: StuScoreVO 学生总分，总成绩
 */
@Data
public class StuScoreVO {
    //学生id
    private Long stuId;
    private Long paperId;//试卷id
    private String nickName;//学生昵称
    private String name;//试卷名称
    private String totalScore;//总分数
}