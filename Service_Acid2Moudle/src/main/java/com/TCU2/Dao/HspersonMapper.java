package com.TCU2.Dao;

import com.TCU2.Domain.Hsperson;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.Collection;
import java.util.List;


/**
* @author zzt
* @description  针对表【hsperson】的数据库操作Mapper
* @createDate 2022-08-13 18:12:03
* @Entity com.epdecodeee.Domain.Hsperson
*/
@Mapper
public interface HspersonMapper extends BaseMapper<Hsperson> {

//    @Insert("insert into hsperson values (grade=#{grade},academy=#{academy},dormitory=#{dormitory},name=#{name},gender=#{gender},college=#{college},department=#{department},copid=#{copid},acidtime=#{acidtime},isacid=#{isacid},phone=#{phone},id=#{id})")
//    boolean InsertUser(Hsperson hsperson);
//    @Select("select name,gender,department,isacid,acidtime,phone from hsperson where isacid=#{isacid}")
//    List<Hsperson> SelectUser(String name);
//    @Delete("delete from hsperson where name=#{name} ")
//    boolean DeleteUSer(String name);
//    @Update("update hsperson set name=#{name},gender=#{gender},college=#{college},department=#{department},copid=#{copid},acidtime=#{acidtime},isacid=#{isacid},phone=#{phone},dormitory=#{dormitory},id=#{id} where name=#{name}")
//    boolean UpdateUSer(String name);
//
//
//    @Select("select name,gender,department,isacid,acidtime,copid,phone,dormitory from hsperson limit #{pageNum},#{pageSize}")
//    List<Hsperson> SelectList(Integer pageNum,Integer pageSize);
    @Select("select * from hsperson ")
    List<Hsperson> SelectAll();
    @Select("select count(*) from hsperson ")
    int SelectCdount();

    @Select(" select DISTINCT Major from  hsperson where department=#{department} ")
    Collection<Hsperson> searchAllByMajorHsperson(@Param("department") String department);

    @Select(" select DISTINCT Dormitory from  hsperson where Major=#{major} ")
    Collection<Hsperson> searchAllByDormitoryHsperson(@Param("major") String major);



    List<Hsperson> callBackHsperson(@Param("id") String id, @Param("name") String name, @Param("major") String major, @Param("department") String department, @Param("grade") String grade, @Param("acidtime") String
                                    acidtime, @Param("dormitory") String dormitory, @Param("dormitorybed") String dormitorybed);
}




