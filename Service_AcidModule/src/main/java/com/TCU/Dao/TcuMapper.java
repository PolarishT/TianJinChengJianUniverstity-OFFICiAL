package com.TCU.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TcuMapper  extends BaseMapper<TcuMapper> {
@Select("select username from tcu")
    String FindUsername(String username);
    @Select("select password from tcu")
    String FindPassword(String password);

}
