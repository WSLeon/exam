package com.mz.auth.service;

import com.mz.auth.entity.ScoreDetail;

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
}