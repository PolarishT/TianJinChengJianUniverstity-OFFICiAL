package com.TCU.Frontend;

import com.TCU.Domain.Hq;
import com.TCU.Domain.Hsperson;
import com.TCU.Domain.Teacher;
import com.TCU.service.HqService;
import com.TCU.service.HspersonService;
import com.TCU.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zzt
 */

@RestController
@Slf4j
public class PageNation {

    @Resource
    HspersonService hspersonService;

    @Resource
    TeacherService teacherService;
    @Resource
    HqService hqService;
    @GetMapping("/PageNationList")
    public IPage<Hsperson> PageNationList(@RequestParam Integer pageNum, @RequestParam Integer pageSize
                                         ){
        IPage<Hsperson> page =new Page<>(pageNum,pageSize);
        QueryWrapper<Hsperson> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("acidtime","未检测");
        hspersonService.count(queryWrapper);
         return   hspersonService.page(page, queryWrapper);
    }
    @GetMapping("/HspersonPageNationListTotal")
    public Integer HspersonPageNationListTotal(){
        QueryWrapper<Hsperson> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("acidtime","未检测");
        return Math.toIntExact(hspersonService.count(queryWrapper));
    }

    @GetMapping("/HqPageNationListTotal")
    public Integer HqPageNationListTotal(){
        QueryWrapper<Hq> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("acidtime","未检测");
        return Math.toIntExact(hqService.count(queryWrapper));
    }
    @GetMapping("/TeacherPageNationListTotal")
    public Integer TeacherPageNationListTotal(){
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("acidtime","未检测");
        return Math.toIntExact(teacherService.count(queryWrapper));
    }

    //分页查询




}
