package com.TCU.Frontend;

import com.TCU.Domain.Hq;
import com.TCU.Domain.Hsperson;
import com.TCU.Domain.Teacher;
import com.TCU.Frontend.Dto.HspersonDto;
import com.TCU.service.HqService;
import com.TCU.service.HspersonService;
import com.TCU.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Objects;


/**
 * @author zzt
 */

@RestController
@Slf4j
public class QueryWrapperRepsonmw {
    @Resource
    HspersonService hspersonService;

    @Resource
    HqService hqService;
    @Resource
    TeacherService teacherService;
    @GetMapping("/QueryWrapperPageNationList")
        public IPage<Hsperson> queryWrapperPageNationList(@RequestParam(defaultValue = "男") String gender,
                                                          @RequestParam(defaultValue = "走读") String livingstatus,
                                                          @RequestParam(defaultValue = "1") Integer pageNum,
                                                          @RequestParam(defaultValue = "1") Integer pageSize){
        IPage<Hsperson> page=new Page<>(pageNum,pageSize);
       QueryWrapper<Hsperson> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("LivingStatus",livingstatus);
        queryWrapper.like("Gender",gender);
        return hspersonService.page(page,queryWrapper);
    }

    @GetMapping("/HqQueryWrapperPageNationList")
    public IPage<Hq> hqQueryWrapperPageNationList(@RequestParam(defaultValue = "男") String gender,
                                                  @RequestParam(defaultValue = "HQ111001") String id,
                                                  @RequestParam(defaultValue = "5") Integer pageNum,
                                                  @RequestParam(defaultValue = "1") Integer pageSize){
        IPage<Hq> page=new Page<>(pageNum,pageSize);
        QueryWrapper<Hq> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        queryWrapper.like("Gender",gender);
        return hqService.page(page,queryWrapper);
    }
    @GetMapping("/TeacherQueryWrapperPageNationList")
    public IPage<Teacher> teacherQueryWrapperPageNationList(@RequestParam(defaultValue = "男") String gender,
                                                            @RequestParam(defaultValue = "000001") String id,
                                                            @RequestParam(defaultValue = "6") Integer pageNum,
                                                            @RequestParam(defaultValue = "1") Integer pageSize){
        IPage<Teacher> page=new Page<>(pageNum,pageSize);
        QueryWrapper<Teacher> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        queryWrapper.like("Gender",gender);
        return teacherService.page(page,queryWrapper);
    }
    @GetMapping("/StudentAcidSortPageNationList")
    public IPage<Hsperson> studentAcidSortPageNationList(@RequestParam(defaultValue = "1") Integer pageNum,
                                                         @RequestParam(defaultValue = "1") Integer pageSize){
    IPage<Hsperson> page=new Page<>(pageNum,pageSize);
    QueryWrapper<Hsperson> lambdaQueryWrapper=new QueryWrapper<>();
        lambdaQueryWrapper.orderByDesc("acidtime");
        return hspersonService.page(page, lambdaQueryWrapper);
    }
    @GetMapping("/HqAcidSortPageNationList")
    public IPage<Hq> hqAcidSortPageNationList(@RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "1") Integer pageSize){
        IPage<Hq> page=new Page<>(pageNum,pageSize);
        QueryWrapper<Hq> lambdaQueryWrapper=new QueryWrapper<>();
        lambdaQueryWrapper.orderByDesc("acidtime");
        return hqService.page(page, lambdaQueryWrapper);
    } @GetMapping("/TeacherAcidSortPageNationList")
    public IPage<Teacher> teacherAcidSortPageNationList(@RequestParam(defaultValue = "1") Integer pageNum,
                                                        @RequestParam(defaultValue = "1") Integer pageSize){
        IPage<Teacher> page=new Page<>(pageNum,pageSize);
        QueryWrapper<Teacher> lambdaQueryWrapper=new QueryWrapper<>();
        lambdaQueryWrapper.orderByDesc("acidtime");
        return teacherService.page(page, lambdaQueryWrapper);
    }



    @PostMapping("/Student")
    public Object studentQueryWrapperAcidSortPageNationList(@RequestParam(defaultValue = "1") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum,
                                                            @RequestBody HspersonDto hspersonDto){

        IPage<Hsperson> hspersondtoiPage =new Page<>(pageNum,pageSize);
        QueryWrapper<Hsperson> hspersonQueryWrapper=new QueryWrapper<>();
        String name=hspersonDto.getName();
        String id=hspersonDto.getId();
        String major=hspersonDto.getMajor();
        String department=hspersonDto.getDepartment();
        String grade=hspersonDto.getGrade();

        if(Objects.equals(hspersonDto.getAcidtime(), "未检测")){
            String re = String.valueOf(hspersonQueryWrapper.eq("acidtime","未检测"));
            System.out.println(re);
            if (hspersonDto.getName() != null) {
                hspersonQueryWrapper.eq("Name",name);
            }
            if (hspersonDto.getGrade() != null){
                hspersonQueryWrapper.eq("Grade",grade);
            }
            if (hspersonDto.getDepartment() != null){
                hspersonQueryWrapper.eq("Department",department);
            }
            if (hspersonDto.getMajor() != null){
                hspersonQueryWrapper.eq("Major",major);
            }
            if (hspersonDto.getDormitory() != null){
                hspersonQueryWrapper.eq("Dormitory",hspersonDto.getDormitory());
            }
            if (hspersonDto.getPhone() != null){
                hspersonQueryWrapper.eq("Phone",hspersonDto.getPhone());
            }
            if (hspersonDto.getId() != null){
                hspersonQueryWrapper.eq("id",id);
            }
            if (hspersonDto.getDormitorybed()!=null) {
                hspersonQueryWrapper.eq("Dormitorybed",hspersonDto.getDormitorybed());
            }


        }
        else {
            if (hspersonDto.getName() != null) {
                hspersonQueryWrapper.eq("Name",name);
            }
            if (hspersonDto.getGrade() != null){
                hspersonQueryWrapper.eq("Grade",grade);
            }
            if (hspersonDto.getDepartment() != null){
                hspersonQueryWrapper.eq("Department",department);
            }
            if (hspersonDto.getMajor() != null){
                hspersonQueryWrapper.eq("Major",major);
            }
            if (hspersonDto.getDormitory() != null){
                hspersonQueryWrapper.eq("Dormitory",hspersonDto.getDormitory());
            }
            if (hspersonDto.getPhone() != null){
                hspersonQueryWrapper.eq("Phone",hspersonDto.getPhone());
            }
            if (hspersonDto.getId() != null){
                hspersonQueryWrapper.eq("id",id);
            }

            hspersonQueryWrapper.orderByDesc("acidtime");
            if (hspersonDto.getDormitorybed()!=null) {
                hspersonQueryWrapper.eq("Dormitorybed",hspersonDto.getDormitorybed());
            }
        }

        return hspersonService.page(hspersondtoiPage,hspersonQueryWrapper);

    }


}
