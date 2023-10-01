package com.mz.auth.mapper;

import com.mz.auth.entity.ScoreDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * @description: ScoreDetailMapper 考试记录
 */
@Mapper
public interface ScoreDetailMapper {
    /**
     * 批量插入  exam_scoredetail考试记录表
     * @param scoreDetailList
     */
    @Insert("<script>insert into exam_scoredetail(stuId,paperId,questionId," +
            "questionTitle,q_typeid," +
            "questionAnswer,questionScore,correntAnswer,correntScore) values" +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.stuId},#{item.paperId},#{item.questionId},#{item.questionTitle}," +
            "#{item.q_typeid},#{item.questionAnswer},#{item.questionScore}," +
            "#{item.correntAnswer},#{item.correntScore})"+
            "</foreach>" +
            "</script>")
    void savePaperTestRecord(List<ScoreDetail> scoreDetailList);

}