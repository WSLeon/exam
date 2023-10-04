package com.mz.auth.service.impl;

import com.mz.auth.entity.ScoreDetail;
import com.mz.auth.entity.StuPaperQuestion;
import com.mz.auth.mapper.StuQuestionRecordsMapper;
import com.mz.auth.service.StuQuestionRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuQuestionRecordsServiceImpl implements StuQuestionRecordsService {

    @Autowired
    private StuQuestionRecordsMapper stuQuestionRecordsMapper;

    @Override
    public StuPaperQuestion queryPaperDetail(ScoreDetail scoreDetail) {
        return stuQuestionRecordsMapper.queryPaperDetail(scoreDetail);
    }
}
