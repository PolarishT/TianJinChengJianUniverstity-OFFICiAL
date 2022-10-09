package com.TCU.Dao;


import com.TCU.Domain.Depart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface DepartMapper extends BaseMapper<Depart> {
    @Delete("delete  from depart where 1=1")
boolean deleByVoid();
//查询用户 的id,parentid
 //   select * from hs whhere id =id
    //通过 parentid 查询  名字


}
