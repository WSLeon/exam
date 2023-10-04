package com.mz.auth.service.impl;

import com.mz.auth.entity.Student;
import com.mz.auth.mapper.StudentMapper;
import com.mz.auth.query.StudentQuery;
import com.mz.auth.service.StudentService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    /**
     * 学生注册
     * @param student
     * @return
     */
    @Override
    public void regStu(Student student) {
        studentMapper.regStu(student);
    }

    /**
     * 学生登录
     * @param student
     * @return
     */
    @Override
    public Student login(Student student) {
        return studentMapper.login(student);
    }
    @Override
    public PageList listPage(StudentQuery studentQuery) {
        /* 把查询到的 总的条数 每页的数据 封装到pageList对象里面去*/
        PageList pageList = new PageList();
        //查询总的条数
        Long total = studentMapper.queryTotal(studentQuery);
        pageList.setTotal(total);
        //查询每页的数据量
        List<Student> students =  studentMapper.queryData(studentQuery);
        pageList.setRows(students);
        //封装到pageList对象里面去
        return pageList;
    }
}