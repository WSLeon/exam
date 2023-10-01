package com.mz.auth.service.impl;

import com.mz.auth.entity.ScoreDetail;
import com.mz.auth.entity.StuPaperQuestion;
import com.mz.auth.mapper.ScoreDetailMapper;
import com.mz.auth.service.StuQuestionRecordsService;
import org.springframework.beans.factory.annotation.Autowired;

public class StuQuestionRecordsServiceImpl implements StuQuestionRecordsService {

    @Autowired
    private ScoreDetailMapper scoreDetailMapper;

    @Override
    public StuPaperQuestion queryPaperDetail(ScoreDetail scoreDetail) {
        return null;
    }
}
