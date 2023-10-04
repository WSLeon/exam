package com.mz.auth.service.impl;

import com.mz.auth.entity.ScoreDetail;
import com.mz.auth.entity.StuScoreVO;
import com.mz.auth.mapper.ScoreDetailMapper;
import com.mz.auth.query.ScoreDetailQuery;
import com.mz.auth.service.ScoreDetailService;
import com.mz.auth.util.PageList;
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
    /**
     * 老师阅卷：分页查询考试记录
     * @param scoreDetailQuery
     * @return
     */
    @Override
    public PageList listPage(ScoreDetailQuery scoreDetailQuery) {
        PageList pageList = new PageList();
        //查询总的条数
        Long total = scoreDetailMapper.queryTotal(scoreDetailQuery);
        pageList.setTotal(total);
        //查询每页的数据
        List<ScoreDetail> scoreDetails =  scoreDetailMapper.queryData(scoreDetailQuery);
        pageList.setRows(scoreDetails);
        return pageList;
    }
}