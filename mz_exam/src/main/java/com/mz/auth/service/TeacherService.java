package com.mz.auth.service;

import com.mz.auth.entity.ScoreDetail;
import com.mz.auth.entity.User;
import com.mz.auth.query.UserQuery;
import com.mz.auth.util.PageList;

public interface TeacherService {
    //添加用户的业务方法
    Long addTeacher(User user);
    PageList    listPage(UserQuery userQuery);
    /**
     * 老师阅卷操作
     * @param scoreDetail
     */
    void updateJdtScore(ScoreDetail scoreDetail);

}