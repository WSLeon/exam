package com.mz.auth.query;

import lombok.Data;

/**
 * @description: ScoreDetailQuery 接收前台的查询参数  问题编号name="questionId"  试卷编号name="paperId"
 */
@Data
public class ScoreDetailQuery  extends BaseQuery{
    /**
     * 试题的编号
     */
    private Long questionId;
    /**
     * 问题编号
     */
    private Long paperId;
}