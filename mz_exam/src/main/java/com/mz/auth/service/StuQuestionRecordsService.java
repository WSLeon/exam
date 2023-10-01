package com.mz.auth.service;

import com.mz.auth.entity.ScoreDetail;
import com.mz.auth.entity.StuPaperQuestion;

/**
 * @description: StuQuestionRecordsService学生问题记录
 */
public interface StuQuestionRecordsService {
    /**
     * 查询学生考卷的每个问题的细节
     * @param scoreDetail
     * @return
     */
    StuPaperQuestion queryPaperDetail(ScoreDetail scoreDetail);
}