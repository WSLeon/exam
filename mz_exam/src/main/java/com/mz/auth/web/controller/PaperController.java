package com.mz.auth.web.controller;

import com.mz.auth.entity.*;
import com.mz.auth.mapper.QuestionMapper;
import com.mz.auth.query.PaperQuery;
import com.mz.auth.service.DicService;
import com.mz.auth.service.PaperService;
import com.mz.auth.util.MzResult;
import com.mz.auth.util.PageList;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "在线考试系统-试卷管理接口")
public class PaperController {

    @Autowired
    private DicService dicService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private QuestionMapper questionMapper;

    @RequestMapping("/paper/queryPaper")
    @ResponseBody
    public List findAll(){
        List<Paper> papers = paperService.findAll();
        return papers;
    }

    /**
     * 跳转试卷列表页面
     * @return
     */
    @GetMapping("/paper/index")
    public String index(Model model){
        //查询试卷等级
        List<DicTypeData> levels = dicService.findLevels();
        model.addAttribute("levels",levels);
        return "views/paper/paper_list";
    }


    @RequestMapping("/paper/listpage")
    @ResponseBody
    public PageList listpage(PaperQuery paperQuery){
        return paperService.listpage(paperQuery);
    }
    @PostMapping("/paper/savePaper")
    @ResponseBody
    public MzResult savePaper(Paper paper){
        try {
            paperService.savePaper(paper);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }
    /**
     * 修改保存试卷
     * @param paper
     * @return
     */
    @PostMapping("/paper/editSavePaper")
    @ResponseBody
    public MzResult editSavePaper(Paper paper){
        try {
            paperService.editSavePaper(paper);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }
    /**
     * 根据试卷 id 删除试卷
     * @param id
     * @return
     */
    @PostMapping("/paper/deletePaper")
    @ResponseBody
    public MzResult deletePaper(Long id) {
        try {
            paperService.deletePaper(id);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }
    /**
     * 跳转 试卷组题页面
     * @return
     */
    @GetMapping("/paper/appendQuestion")
    public String appendQuestion(){
        return "views/paper/paper_question";
    }
    /**
     * 根据试卷id查询所有的问题
     * @return   List<PaperQuestion>
     */
    @PostMapping("/paper/queryQuestionByPaperId")
    @ResponseBody
    public List<PaperQuestion> queryQuestionByPaperId(@RequestBody PaperQuestion paperQuestion) {
        return paperService.queryQuestionByPaperId(paperQuestion.getPaperId());
    }
    /**
     * 手动组卷
     * @param paperQuestion
     * @return
     */
    @PostMapping("/paper/diyPaperQuestion")
    @ResponseBody
//实体表 的paperQuestion对象
    public MzResult diyPaperQuestion(@RequestBody PaperQuestion paperQuestion) {
        try {
            paperService.diyPaperQuestion(paperQuestion);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }
    /**
     * 根据id查询预览试卷信息 跳转页面进行预览试卷
     * @param paperId
     * @return
     */
    @RequestMapping("/paper/previewPaper/{paperId}")
    public String previewPaper(@PathVariable("paperId") Long paperId, Model model){
        //根据试卷id 查询出试卷的信息
        PaperGengerateVO paperGengerateVO= paperService.previewPaper(paperId);
        //model来存储查询到的信息，paperGengerateVO对象，然后前台再把信息取出来
        model.addAttribute("paperGengerateVO",paperGengerateVO);
        //跳转到预览页面
        return "views/paper/paper_preview";
    }
    /**
     * 查询题型的总数  List<TypeTotalVO>
     * queryTypeTotal
     */
    @PostMapping("/paper/queryTypeTotal")
    @ResponseBody  //返回的json格式的数据
    public List<TypeTotalVO> queryTypeTotal(){
        return paperService.queryTypeTotal();
    }
    /**
     * 随机组卷的方法
     */
    @PostMapping("/paper/randomPaperQuestion")
    @ResponseBody
    public MzResult randomPaperQuestion(@RequestBody Map mp){
        try {
            paperService.randomPaperQuestion(mp);
            return MzResult.ok();//返回成功
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());//返回失败，打印出失败消息
        }
    }

}