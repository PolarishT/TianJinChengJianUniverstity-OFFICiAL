package com.TCU.Vertify.HQ;


import com.TCU.Domain.Hq;
import com.TCU.Result.Result;
import com.TCU.service.HqService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import static com.TCU.Commons.DistanceTime.getDistanceTime;


@Service
@Slf4j
public class JudegefaultHQ {


    @Autowired
   private HqService hqService;
    @ApiImplicitParams({
            @ApiImplicitParam(name ="socketRaw->JudgeDefault",value = "SendAllWebsocket-> data",paramType = "String",required = true),
    })
    @ApiModelProperty(required = true,value = "UerINfoMeta",allowEmptyValue = true,dataType = "hsperson")

    public Object JudgeHQ(String qrcode,String ID) throws IOException {
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

           Hq hq=new Hq();
            if (!(ID.equals(hqService.getById(ID).getId()))) {
            throw new  RuntimeException();
            } else {
                hq.setId(ID);
                hq.setAcidtime(String.valueOf(CurrentTime));
            }
            try {
                hqService.saveOrUpdate(hq);
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
        return Result.ResSuccess("OK");
    }
}
