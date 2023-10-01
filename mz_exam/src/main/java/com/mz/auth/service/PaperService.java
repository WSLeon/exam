package com.mz.auth.service;

import com.mz.auth.entity.Paper;
import com.mz.auth.entity.PaperGengerateVO;
import com.mz.auth.entity.PaperQuestion;
import com.mz.auth.entity.TypeTotalVO;
import com.mz.auth.query.PaperQuery;
import com.mz.auth.util.PageList;

import java.util.List;
import java.util.Map;

public interface PaperService {
    /**
     * 分页方法
     */
    PageList listpage(PaperQuery paperQuery);
    /**
     * 查询所有的paper
     */
    List<Paper> findAll();
    /**
     * 保存试卷
     * @param paper
     */
    void savePaper(Paper paper);
    /**
     * 修改保存试卷
     * @param paper
     */
    void editSavePaper(Paper paper);
    /**
     * 删除试卷
     * @param id
     */
    void deletePaper(Long id);
    List<PaperQuestion> queryQuestionByPaperId(Long paperId);
    /**
     * 手动组卷
     * @param paperQuestion
     */
    void diyPaperQuestion(PaperQuestion paperQuestion);
    /**
     * 预览试卷方法
     * @param paperId
     * @return
     */
    PaperGengerateVO previewPaper(Long paperId);
    /**
     * 查询题类型的总数
     * @return
     */
    List<TypeTotalVO> queryTypeTotal();
    /**
     * 随机组卷
     * @param mp
     */
    void randomPaperQuestion(Map mp);

}