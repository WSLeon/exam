package com.mz.auth.web.controller;

import com.mz.auth.entity.ScoreDetail;
import com.mz.auth.entity.User;
import com.mz.auth.query.ScoreDetailQuery;
import com.mz.auth.query.UserQuery;
import com.mz.auth.service.ScoreDetailService;
import com.mz.auth.service.TeacherService;
import com.mz.auth.util.MzResult;
import com.mz.auth.util.PageList;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "在线考试系统-教师管理接口")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    //添加用户
    @RequestMapping("/teacher/addTeacher")
    @ResponseBody
    public Long addTeacher(User user) {
        System.out.println("保存老师用户...." + user);
        user.setType(2);//type=2是老师
        teacherService.addTeacher(user);
        Long userId = user.getId();
        return userId;
    }
    @GetMapping("/teacher/index")
    public String index(){
        return "views/teacher/teacher_list";
    }
    /**
     * 响应老师列表分页数据的
     * @param userQuery
     * @return
     */
    @GetMapping("/teacher/listpage")
    @ResponseBody
    public PageList listPage(UserQuery userQuery){
        userQuery.setType(2);//用户类型为2 老师
        //调用userService层 listPage方法，进行分页
        return teacherService.listPage(userQuery);
    }
    @Autowired
    private ScoreDetailService scoreDetailService;
    /**
     * 跳转老师阅卷页面
     * @return
     */
    @GetMapping("/teacher/paperExamRecord")
    public String paperExamRecord(){
        return "views/teacher/paper_check";
    }

    /**
     * 老师阅卷
     * /teacher/paperExamlistpage
     * @param scoreDetailQuery
     * @return
     */
    @GetMapping("/teacher/paperExamlistpage")
    @ResponseBody
    public PageList listPaperExamPage(ScoreDetailQuery scoreDetailQuery){
        return scoreDetailService.listPage(scoreDetailQuery);
    }
    /**
     * 老师阅卷操作
     * @param scoreDetail
     * @return
     */
    @PostMapping("/teacher/updateJdtScore")
    @ResponseBody
    public MzResult updateJdtScore(ScoreDetail scoreDetail){
        try {
            teacherService.updateJdtScore(scoreDetail);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

}