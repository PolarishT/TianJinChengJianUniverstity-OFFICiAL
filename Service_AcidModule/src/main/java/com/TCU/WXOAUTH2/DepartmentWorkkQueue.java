package com.TCU.WXOAUTH2;


import com.TCU.Config.HttpClientHelper;
import com.TCU.Dao.DepartMapper;
import com.TCU.Domain.Depart;
import com.TCU.service.DepartService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;


@RestController
@Api("Department Working")
public class DepartmentWorkkQueue {

@Resource
    StringRedisTemplate    stringRedisTemplate;
   @Resource
   DepartService departService;
   @Resource
   DepartMapper departMapper;
    @GetMapping("/putDnum")
    @CachePut(value = "DepartService")
    @Async("OtherPool")
    public void GainDepartment() throws IOException {
        String ID = "1";
        String gainURl = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=" + stringRedisTemplate.opsForValue().get("ack") + "&id=" + ID;
        String s = HttpClientHelper.SendGet(gainURl);
        com.alibaba.fastjson.JSONObject jsonObject = (com.alibaba.fastjson.JSONObject) com.alibaba.fastjson.JSON.parse(s);
        String js = jsonObject.getString("department");
        System.out.println(js);
        JSONArray jsonArray = JSON.parseArray(js);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject o1 = (JSONObject) jsonArray.get(i);
            Depart depart = new Depart((Integer) o1.get("id"), o1.get("name").toString(), (Integer) o1.get("parentid"));
            departService.save(depart);
        }
    }



    @GetMapping("/GyDepart")
    public List<Depart> GetDepart(){
        return departService.list();
    }


    @GetMapping("/deleteDepart")
    @CacheEvict(cacheNames = "DepartService",allEntries=true)
    @Async("OtherPool")
    public void deleteDepart(){
      departMapper.deleByVoid();
    }
}
