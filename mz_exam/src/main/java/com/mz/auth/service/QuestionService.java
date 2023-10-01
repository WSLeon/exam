package com.mz.auth.service;

import com.mz.auth.entity.Question;
import com.mz.auth.query.QuestionQuery;
import com.mz.auth.util.PageList;

/**
 * @description: QuestionService
 */

public interface QuestionService {
    /**
     * 分页查询数据
     * @param questionQuery
     * @return
     */
    PageList listPage(QuestionQuery questionQuery);
    /**
     * 保存问题方法
     * @param question
     */
    void addQuestion(Question question);
    /**
     * 根据问题id 查询问题
     * @param qid
     * @return
     */
    Question queryQuestionByQid(Long qid);
    /**
     * 根据问题id修改问题
     * @param question
     */
    void editQuestion(Question question);
    /**
     * 根据问题id删除问题
     * @param id
     */
    void deleteQuestion(Long id);
}