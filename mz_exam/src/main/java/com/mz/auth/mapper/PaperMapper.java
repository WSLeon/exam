package com.mz.auth.mapper;

import com.mz.auth.entity.Paper;
import com.mz.auth.entity.PaperGengerateVO;
import com.mz.auth.entity.PaperQuestion;
import com.mz.auth.entity.TypeTotalVO;
import com.mz.auth.query.PaperQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @description:
 */
@Mapper
public interface PaperMapper {

    /**
     * 查询总的条数
     * @param paperQuery
     * @return
     */
    Long queryTotal(PaperQuery paperQuery);

    /**
     * 查询当前页的数据
     * @param paperQuery
     * @return
     */
    List<Paper> queryData(PaperQuery paperQuery);

    /**
     * 查询所有
     * @return
     */
    List<Paper> findAll();
    /**
     * 保存试卷
     * @param paper
     */
    @Insert("insert into exam_paper(name,startTime,endTime,createTime,status,levelid) " +
            "values (#{name},#{startTime},#{endTime},#{createTime},#{status},#{levelid})")
    void savePaper(Paper paper);
    /**
     * 修改试卷
     * @param paper
     */
    @Update("update exam_paper set name=#{name},startTime=#{startTime},endTime=#{endTime},levelid=#{levelid} " +
            "where id=#{id}")
    void editSavePaper(Paper paper);
    /**
     * 删除组题记录 paperId=#{id}
     * @param id
     */
    @Delete("delete from exam_paper_question where paperId=#{id}")
    void deletePaperQuestion(Long id);


    /**
     * 删除试卷 id=#{id}
     */
    @Delete("delete from exam_paper where id=#{id}")
    void deletePaper(Long id);
    /**
     * 试题组卷：根据试卷id查询对应的问题记录
     * @param paperId
     * @return
     */
    /**
     * 试题组卷
     * @param paperId
     * @return
     */
    @Select("select * from exam_paper_question where paperId=#{paperId}")
    List<PaperQuestion> queryQuestionByPaperId(Long paperId);
    /**
     * 批量插入试卷对应的 试题表 里面 即试卷问题表
     * @param params
     */
    @Insert("<script>insert into exam_paper_question(paperId,questionId) " +
            "values" +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.paperId},#{item.questionId})"+
            "</foreach>"+
            "</script>")
    void insertBatchPaperQuestion(List<Map> params);

    /**
     * 预览试卷方法   用xml方式查询，因为sql较复杂，不用注解
     * @param paperId
     * @return
     */
    PaperGengerateVO previewPaper(Long paperId);
    /**
     * 查询题型的总数  group by根据 q_typeid来查询totalNum总数量  如选择题一共5条
     * @return
     */
    @Select("select q_typeid,count(*) totalNum\n" +
            "from exam_questionbank\n" +
            "group by q_typeid")
    List<TypeTotalVO> queryTypeTotal();
    /**
     * 查询所有的对应题型的 问题id 都有哪些
     * @param q_typeid
     * @return
     */
    @Select("select id from exam_questionbank where q_typeid=#{q_typeid} ")
    @ResultType(Long.class)
//前台传过来的题型参数q_typeid
    List<Long> queryQuestionIdByTypeId(long q_typeid);
}