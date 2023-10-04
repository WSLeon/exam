package com.mz.auth.service;

import com.mz.auth.entity.ScoreDetail;
import com.mz.auth.entity.StuScoreVO;

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
}