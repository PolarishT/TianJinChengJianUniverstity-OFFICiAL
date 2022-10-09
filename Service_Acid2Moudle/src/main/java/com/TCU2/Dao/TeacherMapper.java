package com.TCU2.Dao;


import com.TCU2.Domain.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.Collection;


/**
* @author Lenovo
* @description 针对表【teacher】的数据库操作Mapper
* @createDate 2022-09-22 16:50:22
* @Entity com.epdecodeee.Domain.Teacher
*/
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    @Select(" select DISTINCT Department from  teacher where department=#{department}")
    Collection<Teacher> searchAllByMajorTeacher(String department);
}




