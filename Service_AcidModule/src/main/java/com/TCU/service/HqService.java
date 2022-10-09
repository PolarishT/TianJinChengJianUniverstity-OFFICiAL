package com.TCU.service;


import com.TCU.Domain.Hq;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;

/**
* @author zzt
* @description 针对表【hq】的数据库操作Service
* @createDate 2022-09-27 23:17:35
*/
public interface HqService extends IService<Hq> {

    Collection<Hq> searchAllByMajorHq(String department);
}
