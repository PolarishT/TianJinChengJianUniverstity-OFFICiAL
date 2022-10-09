package com.TCU2.BaseResponse;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BaseMapperlocation extends BaseMapper<Base> {
    @Select("select* from hsperson as s,BaseMap as b where s.id=#{id} and b.id=s.id")
    String fong(String id);




}
