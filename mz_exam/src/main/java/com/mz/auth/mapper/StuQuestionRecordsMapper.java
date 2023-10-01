package com.mz.auth.mapper;

import com.mz.auth.entity.ScoreDetail;
import com.mz.auth.entity.StuPaperQuestion;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: ScoreDetailMapper 考试记录
 */
@Mapper
public interface StuQuestionRecordsMapper {

    StuPaperQuestion queryPaperDetail(ScoreDetail scoreDetail);

}