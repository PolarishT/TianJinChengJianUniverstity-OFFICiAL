package com.TCU2.service.impl;



import com.TCU2.Dao.HspersonMapper;
import com.TCU2.Domain.Hsperson;
import com.TCU2.service.HspersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;


/**
* @author zzt
* @description 针对表【hsperson】的数据库操作Service实现
* @createDate 2022-09-21 15:19:05
*/
@Service
public class HspersonServiceImpl extends ServiceImpl<HspersonMapper, Hsperson>
    implements HspersonService {
    @Autowired
    HspersonMapper hspersonMapper;
public Collection<Hsperson> searchAllByMajorHsperson(String department){
   return hspersonMapper.searchAllByMajorHsperson(department);

}

    @Override
    public Collection<Hsperson> searchAllByDormitoryHsperson(String major) {
        return hspersonMapper.searchAllByDormitoryHsperson(major);
    }

    @Override
    public List<Hsperson> callBackHsperson(String id, String name, String major, String department, String grade, String acidtime, String dormitory, String dormitorybed) {
        return hspersonMapper.callBackHsperson(id, name, major, department, grade, acidtime, dormitory, dormitorybed);
    }
}




