package com.TCU.service.impl;


import com.TCU.Dao.HqMapper;
import com.TCU.Domain.Hq;
import com.TCU.service.HqService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
* @author zzt
* @description 针对表【hq】的数据库操作Service实现
* @createDate 2022-09-27 23:17:35
*/
@Service
public class HqServiceImpl extends ServiceImpl<HqMapper, Hq>
    implements HqService {
@Autowired
HqMapper hqMapper;
    @Override
    public Collection<Hq> searchAllByMajorHq(String department) {
        return hqMapper.searchAllByMajorHq(department);
    }
}




