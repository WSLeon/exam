package com.mz.auth.service;

import com.mz.auth.entity.ScoreDetail;
import com.mz.auth.entity.StuScoreVO;
import com.mz.auth.query.ScoreDetailQuery;
import com.mz.auth.util.PageList;

import java.util.List;

/**
 * @description: ScoreDetailService 考试记录
 */
public interface ScoreDetailService {
    /**
     * 保存考试记录
     * @param scoreDetailList
     */
    void savePaperTestRecord(List<ScoreDetail> scoreDetailList);
    /**
     * 查询学生成绩
     * @param stuScoreVO
     * @return
     */
    StuScoreVO queryFrontStuScore(StuScoreVO stuScoreVO);
    List<StuScoreVO> queryFrontAllStuScore( Long stuId);
    void deleteStuPaper(Long paperid,Long stuid);
    /**
     * 老师阅卷：分页查询考试记录数据
     */
    PageList listPage(ScoreDetailQuery scoreDetailQuery);
}