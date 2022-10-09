package com.TCU.Frontend;

import com.TCU.Dao.TcuMapper;
import com.TCU.Domain.Hsperson;
import com.TCU.Frontend.Dto.HspersonDto;
import com.TCU.Result.Result;
import com.TCU.service.HspersonService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @author zzt
 */
@RestController
@Slf4j
public class LoGin {
@Resource
TcuMapper tcuMapper;
@Resource
HspersonService hspersonService;


@GetMapping("/lgin")
    public Object sendAllWebSocket(@RequestParam("username") String username, @RequestParam("password") String password) {
    if (username.isEmpty()||password.isEmpty()) {
            return  Result.ResUser("UserName:"+username+"|"+"PassWord"+password);
        }
        else {
            if(username.equals(tcuMapper.FindUsername(username))&&password.equals(tcuMapper.FindPassword(password))){
                return Result.ResSuccess("success");
            }
        }
        return Result.ResUser("UserName or PassWord error");
    }
@PostMapping("/Student")
    public Object Sdqd(@RequestParam(defaultValue = "1") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum,
                     @RequestBody HspersonDto hspersonDto){

    IPage<Hsperson> hspersonDtoIPage=new Page<>(pageNum,pageSize);
QueryWrapper<Hsperson> hspersonQueryWrapper=new QueryWrapper<>();
String name=hspersonDto.getName();
    String id=hspersonDto.getId();
    String major=hspersonDto.getMajor();
    String department=hspersonDto.getDepartment();
    String grade=hspersonDto.getGrade();

    if(hspersonDto.getAcidtime()==null){
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
        if (!hspersonDto.getAcidtime().equals("未检测")){
            hspersonQueryWrapper.orderByDesc("acidtime");
        }
        if (hspersonDto.getDormitorybed()!=null) {
            hspersonQueryWrapper.eq("Dormitorybed",hspersonDto.getDormitorybed());
        }
    }
    
return hspersonService.page(hspersonDtoIPage,hspersonQueryWrapper);

}

}

