package com.TCU.Controller;


import com.TCU.Domain.Hsperson;
import com.TCU.service.HspersonService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CCRUDD {
 @Autowired
private HspersonService hspersonService;
    @PostMapping("/InsertHsperson")
    Boolean InsertHsperson(Hsperson hsperson){
      return   hspersonService.saveOrUpdate(hsperson);
    }



    @GetMapping("/PageList")
    public IPage<Hsperson> PageList(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestParam(defaultValue = "") String name,
                                    @RequestParam(defaultValue = "") String department,
                                    @RequestParam(defaultValue = "") Boolean isacid,
                                    @RequestParam(defaultValue = "") String  userid
    ){
        IPage<Hsperson> page=new Page<>(pageNum,pageSize);
        QueryWrapper<Hsperson> wrapper = new QueryWrapper<>();
        wrapper.like("name",name);
        wrapper.like("department",department);
        wrapper.like("isacid",isacid);
        wrapper.like("userid",userid);
        return hspersonService.page(page,wrapper);
    }



}
