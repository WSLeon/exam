package com.mz.auth.web.controller.front;

import com.mz.auth.entity.Student;
import com.mz.auth.service.StudentService;
import com.mz.auth.util.MzResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;


/**
 * @description: StudentController
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 注册学生账号信息
     * @param student
     * @return
     */
    @RequestMapping("/stu/regStu")
    @ResponseBody
    public MzResult regStu(Student student){
        try {
            studentService.regStu(student);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    //学生登录
    @RequestMapping("/stu/login")
    @ResponseBody
    public MzResult login(Student student, HttpSession session){

        try {
            //判断验证码是否正确]
            String code = (String)session.getAttribute("code");
            if(!code.equals(student.getUsercode())){
                return MzResult.error("验证码输入有错误!");
            }

            Student stu =  studentService.login(student);
            if(stu==null){
                return MzResult.error("用户名或者密码错误");
            }else{

                session.setAttribute("stuUser",stu);
                return MzResult.ok();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }
}