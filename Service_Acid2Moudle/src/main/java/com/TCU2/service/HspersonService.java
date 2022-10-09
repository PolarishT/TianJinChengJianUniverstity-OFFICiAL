package com.TCU2.service;


import com.TCU2.Domain.Hsperson;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import java.util.Collection;
import java.util.List;

/**
* @author zzt
* @description 针对表【hsperson】的数据库操作Service
* @createDate 2022-09-21 15:19:05
*/
public interface HspersonService extends IService<Hsperson> {
    Collection<Hsperson> searchAllByMajorHsperson(String department);

    Collection<Hsperson> searchAllByDormitoryHsperson( String major);

    List<Hsperson> callBackHsperson(@Param("id") String id, @Param("name") String name, @Param("major") String major, @Param("department") String department, @Param("grade") String grade, @Param("acidtime") String
            acidtime, @Param("dormitory") String dormitory, @Param("dormitorybed") String dormitorybed);
}
