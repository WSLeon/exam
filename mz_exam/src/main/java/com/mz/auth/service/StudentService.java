package com.mz.auth.service;

import com.mz.auth.entity.Student;

/**
 * @description: StudentService
 */
public interface StudentService {

    /**
     * 注册学生账号
     * @param student
     */
    void regStu(Student student);

    /**
     * 学生登录
     * @param student
     * @return
     */
    Student login(Student student);
}