package com.TCU2.Vertify.Student;

import com.TCU2.Dao.MasterMapper;
import com.TCU2.Domain.Hsperson;
import com.TCU2.Domain.Master;
import com.TCU2.Result.Result;
import com.TCU2.service.DepartService;
import com.TCU2.service.HspersonService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import static com.TCU2.Commons.DistanceTime.getDistanceTime;


@Service
@Slf4j
public class Judge {
    @Resource
    HspersonService hspersonService;
    @Autowired
    MasterMapper masterMapper;

  Master master;
@Resource
DepartService departService;
@Resource
    StringRedisTemplate stringRedisTemplate;

    @ApiImplicitParams({
            @ApiImplicitParam(name ="socketRaw->JudgeDefault",value = "SendAllWebsocket-> data",paramType = "String",required = true),
    })
    @ApiModelProperty(required = true,value = "UerINfoMeta",allowEmptyValue = true,dataType = "hsperson")

    public Object JudgeDefaultSTU(String qrcode,String ID) throws IOException {

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CurrentTime=simpleDateFormat.format(new Date().getTime());
         Date date=new Date();
        String format = simpleDateFormat.format(date);
        String[] split = qrcode.split("/");
        log.info("ACIdTime",split[5]);
        int distanceTime = getDistanceTime(CurrentTime, split[5]);
      if(distanceTime>10){
          return Result.ResUserTime(String.valueOf(distanceTime));
     }else {
          Hsperson hsperson=new Hsperson();

          if (!(ID.equals(hspersonService.getById(ID).getId()))) {
              throw new  RuntimeException();
          } else {
              hsperson.setId(ID);
              hsperson.setAcidtime(String.valueOf(CurrentTime));
          }
          try {
              hspersonService.saveOrUpdate(hsperson);
          } catch (Exception e) {
              throw new RuntimeException();
          }
      }
        return Result.ResSuccess("OK");
    }

}

