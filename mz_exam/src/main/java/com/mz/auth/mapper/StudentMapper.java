package com.mz.auth.mapper;

import com.mz.auth.entity.Student;
import com.mz.auth.query.StudentQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description: StudentMapper
 */
@Mapper
public interface StudentMapper {

    /**
     * 注册学生
     * @param student
     */
    @Insert("insert into t_student(username,password,tel,email,stuNum,createTime,nickName)" +
            " values(#{username},#{password},#{tel},#{email},#{stuNum},#{createTime},#{nickName})")
    void regStu(Student student);

    /**
     * 学生登录
     * @param student
     * @return
     */
    @Select("select * from t_student where username =#{username} and password=#{password}")
    Student login(Student student);
    /**
     * 查询总的条数
     * @param studentQuery
     * @return
     */
    Long queryTotal(StudentQuery studentQuery);

    /**
     * 查询当前页的数据
     * @param studentQuery
     * @return
     */
    List<Student> queryData(StudentQuery studentQuery);
}