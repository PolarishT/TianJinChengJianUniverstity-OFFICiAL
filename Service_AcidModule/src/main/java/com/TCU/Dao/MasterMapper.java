package com.TCU.Dao;


import com.TCU.Domain.Master;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MasterMapper extends BaseMapper<Master> {
    @Select("select id from hsjc.master where id=#{id}")
     Boolean SelectByMID(String id);
}
