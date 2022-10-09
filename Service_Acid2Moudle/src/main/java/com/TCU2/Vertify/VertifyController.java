package com.TCU2.Vertify;

import com.TCU2.Dao.HspersonMapper;
import com.TCU2.Result.Result;
import com.TCU2.Vertify.HQ.JudegefaultHQ;
import com.TCU2.Vertify.Student.Judge;
import com.TCU2.Vertify.Teacher.Judegefault;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.io.IOException;

@RestController
@Slf4j
@Api("Vertify Schduler Async")
public class VertifyController {

    @Resource
    HspersonMapper hspersonMapper;
    @Resource
   private Judge judge;
    @Resource
    private Judegefault judegefault;
    @Resource
    private JudegefaultHQ judegefaultHQ;

@PostMapping("/JudgeDefault")
@Transactional(rollbackFor = Exception.class)
    public Object JudgeDefault(@RequestParam String qrcode, @RequestBody String ID){

    if(qrcode == null||ID==null){
        return Result.ResUserResponseError(qrcode,ID);
    }
    if(ID.length()>10||ID.length()<6){
        return Result.error("900","参数不合法");
    }

    if(ID.startsWith("HQ")){
        try {
    return judegefaultHQ.JudgeHQ(qrcode,ID);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    if(ID.length()==10){
        try {
          return   judge.JudgeDefaultSTU(qrcode,ID);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
 if(ID.length()==7) {
     try {
        return judegefault.JudgeTeacher(qrcode, ID);
     } catch (IOException e) {
         throw new RuntimeException(e);
     }
 }

        return Result.misserror();

}



}
