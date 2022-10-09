package com.TCU.service;


import com.TCU.Domain.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.Collection;

/**
* @author zzt
* @description 针对表【teacher】的数据库操作Service
* @createDate 2022-09-22 16:50:22
*/
public interface TeacherService extends IService<Teacher> {

    Collection<Teacher> searchAllByMajorTeacher(String department);
}
