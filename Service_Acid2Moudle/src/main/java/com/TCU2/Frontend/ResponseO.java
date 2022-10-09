package com.TCU2.Frontend;


import com.TCU2.service.HqService;
import com.TCU2.service.HspersonService;
import com.TCU2.service.TeacherService;
import com.TCU2.Domain.Hq;
import com.TCU2.Domain.Hsperson;
import com.TCU2.Domain.Teacher;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author zzt
 */

@RestController
@Slf4j
public class ResponseO {
    @Resource
    HspersonService hspersonService;
    @Resource
    TeacherService teacherService;
    @Resource
    HqService hqService;


    @GetMapping("/TeacherPageNationList")
    public IPage<Teacher> pageNationTeacherList(@RequestParam Integer pageNum, @RequestParam Integer pageSize
    ) {
        IPage<Teacher> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        return teacherService.page(page, queryWrapper);
    }

    @GetMapping("/StudentPageNationList")
    public IPage<Hsperson> PageNationStudentList(@RequestParam Integer pageNum, @RequestParam Integer pageSize
    ) {
        IPage<Hsperson> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Hsperson> queryWrapper = new QueryWrapper<>();
        return hspersonService.page(page, queryWrapper);
    }

    @GetMapping("/HqPageNationList")
    public IPage<Hq> PageNationList(@RequestParam Integer pageNum, @RequestParam Integer pageSize
    ) {
        IPage<Hq> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Hq> queryWrapper = new QueryWrapper<>();
        return hqService.page(page, queryWrapper);
    }


    @GetMapping("/HqTotal")
    public long HqPageNationList() {
        QueryWrapper<Hq> queryWrapper=new QueryWrapper<>();
        QueryWrapper<Hq> acidtime = queryWrapper.isNotNull("acidtime");
        return hqService.count(acidtime);
    }
    @GetMapping("/HspersonMajorINfoTotal")
    public Collection<Hsperson> hspersonDepartmentINfoTotal(String department) {
        return hspersonService.searchAllByMajorHsperson(department);
    }
    @GetMapping("/TeacherMajorINfoTotal")
    public Collection<Teacher> TeacherDepartmentINfoTotal(String department) {
        return teacherService.searchAllByMajorTeacher(department);
    }
    @GetMapping("/HqMajorINfoTotal")
    public Collection<Hq> HqDepartmentINfoTotal(String department) {
        return hqService.searchAllByMajorHq(department);
    }
    @GetMapping("/HspersonMajorToDepartmentTotal")
    public Collection<Hsperson> HspersonMajorToDepartmentTotal(String major) {
        return hspersonService.searchAllByDormitoryHsperson(major);
    }
    @PostMapping("/S")
    public String studentQueryWrapperAcidSortPageNationList(@RequestBody String ID) {
        System.out.println(ID);
        return "";
    }




}