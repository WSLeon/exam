package com.mz.auth.mapper;

import com.mz.auth.entity.ScoreDetail;
import com.mz.auth.entity.StuScoreVO;
import com.mz.auth.query.ScoreDetailQuery;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

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

    /**
     * 查询学生的成绩 使用xml方式
     * @param stuScoreVO
     * @return
     */
    StuScoreVO queryFrontStuScore(StuScoreVO stuScoreVO);

    List<StuScoreVO> queryFrontAllStuScore( Long stuId);
    @Delete("delete from exam_scoredetail where paperId=#{paperid} and stuId=#{stuid}")
    void deleteStuPaper(Long paperid,Long stuid);
    /**
     * 老师阅卷：查询考试记录的总数
     * @param scoreDetailQuery
     * @return
     */
    Long queryTotal(ScoreDetailQuery scoreDetailQuery);

    /**
     * 老师阅卷：查询考试记录的分页数据
     * @param scoreDetailQuery
     * @return
     */
    List<ScoreDetail> queryData(ScoreDetailQuery scoreDetailQuery);
    /**
     * 老师阅卷操作 根据id设置exam_scoredetail表字段 correntscore
     * @param scoreDetail
     */
    @Update("update exam_scoredetail set correntscore=#{correntScore} where id=#{id}")
    void updateJdtScore(ScoreDetail scoreDetail);
}