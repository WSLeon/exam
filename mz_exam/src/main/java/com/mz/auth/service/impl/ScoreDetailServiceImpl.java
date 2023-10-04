package com.mz.auth.service.impl;

import com.mz.auth.entity.ScoreDetail;
import com.mz.auth.entity.StuScoreVO;
import com.mz.auth.mapper.ScoreDetailMapper;
import com.mz.auth.service.ScoreDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 */
@Service
public class ScoreDetailServiceImpl implements ScoreDetailService {

    @Autowired
    private ScoreDetailMapper scoreDetailMapper;

    /**
     * 保存考试记录
     * @param scoreDetailList
     */
    @Override
    public void savePaperTestRecord(List<ScoreDetail> scoreDetailList) {
        scoreDetailMapper.savePaperTestRecord(scoreDetailList);//调用
    }
    /**
     * 查询学生的成绩
     * @param stuScoreVO
     * @return
     */
    @Override
    public StuScoreVO queryFrontStuScore(StuScoreVO stuScoreVO) {
        return scoreDetailMapper.queryFrontStuScore(stuScoreVO);
    }
    @Override
    public List<StuScoreVO> queryFrontAllStuScore(Long stuId) {
        return scoreDetailMapper.queryFrontAllStuScore(stuId);
    }

    @Override
    public void deleteStuPaper(Long paperid, Long stuid) {
         scoreDetailMapper.deleteStuPaper(paperid,stuid);
    }
}