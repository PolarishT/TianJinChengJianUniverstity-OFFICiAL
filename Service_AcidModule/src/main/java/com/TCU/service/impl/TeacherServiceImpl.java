package com.TCU.service.impl;


import com.TCU.Dao.TeacherMapper;
import com.TCU.Domain.Teacher;
import com.TCU.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;


/**
* @author zzt
* @description 针对表【teacher】的数据库操作Service实现
* @createDate 2022-09-22 16:50:22
*/
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public Collection<Teacher> searchAllByMajorTeacher(String department) {
        return teacherMapper.searchAllByMajorTeacher(department);
    }
}




