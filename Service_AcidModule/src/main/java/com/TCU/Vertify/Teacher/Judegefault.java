package com.TCU.Vertify.Teacher;


import com.TCU.Domain.Teacher;
import com.TCU.Excption.BusinessException;
import com.TCU.Excption.ErrorCode;
import com.TCU.Result.Result;
import com.TCU.service.TeacherService;
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

@Slf4j
@Service
public class Judegefault {

    @Autowired
    TeacherService teacherService;

    @ApiImplicitParams({
            @ApiImplicitParam(name ="socketRaw->JudgeDefault",value = "SendAllWebsocket-> data",paramType = "String",required = true),
    })
    @ApiModelProperty(required = true,value = "UerINfoMeta",allowEmptyValue = true,dataType = "hsperson")

    public Object JudgeTeacher(String qrcode,String ID) throws IOException {


//        String ID= String.valueOf(hsperson.getId());
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
            Teacher teacher=new Teacher();
            if (!ID.equals(teacherService.getById(ID).getId())) {
                throw new BusinessException(ErrorCode.NO_AUTH);
            } else {
                teacher.setId(ID);
                teacher.setAcidtime(String.valueOf(CurrentTime));
            }
            try {
                teacherService.saveOrUpdate(teacher);
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
        return Result.ResSuccess("OK");
    }
}
