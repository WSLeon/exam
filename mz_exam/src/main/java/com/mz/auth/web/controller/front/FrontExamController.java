package com.mz.auth.web.controller.front;

import com.mz.auth.entity.PaperGengerateVO;
import com.mz.auth.entity.ScoreDetail;
import com.mz.auth.service.PaperService;
import com.mz.auth.service.ScoreDetailService;
import com.mz.auth.util.MzResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @description: FrontExamController 前台考试记录的controller
 */
@Controller
public class FrontExamController {

    @Autowired
    private PaperService paperService;
    @Autowired
    private ScoreDetailService scoreDetailService;


    /**
     * 前台弹出测试（考试）页面
     * @param model
     * @param paperId
     * @return
     */
    @RequestMapping("/exam/popPaper/{paperId}")
    public String popPaper(Model model , @PathVariable("paperId") Long paperId){

        PaperGengerateVO paperGengerateVO = paperService.previewPaper(paperId);

        model.addAttribute("examPapersVO",paperGengerateVO);

        return "front/examPaper";
    }

    /**
     * 保存学生考试记录
     * examPaper
     */
    @RequestMapping("/stu/examPaper")
    @ResponseBody
    public MzResult examPaper(@RequestBody List<ScoreDetail> scoreDetails,Long paperId,Long stuId){//@RequestBody前台是json形式的数据 到后台
        try {
            scoreDetailService.deleteStuPaper(paperId,stuId);
            scoreDetailService.savePaperTestRecord(scoreDetails);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }
}