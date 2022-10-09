package com.TCU2.Dao;


import com.TCU2.Domain.Hq;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;

/**
* @author Lenovo
* @description  针对表【hq】的数据库操作Mapper
* @createDate 2022-09-27 23:17:35
* @Entity com.epdecodeee.Domain.Hq
*/
@Mapper
public interface HqMapper extends BaseMapper<Hq> {
    @Select(" select DISTINCT Department from  hq where department=#{department}")
    Collection<Hq> searchAllByMajorHq(String department);
}




