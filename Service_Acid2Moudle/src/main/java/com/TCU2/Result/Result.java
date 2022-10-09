package com.TCU2.Result;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String code;
    private String msg;
    private  Object data;

    private static Result Success(){
        return new Result(Constants.CODE_200,"",null);
    }
    public static Result Success(Object data){
        return new Result(Constants.CODE_200,"",data);
    }
    public static Result error(String code,String msg){
        return new Result(code,msg,null);
    }
    public static Result Responseerror(){
        return new Result(Constants.CODE_500,"服务器数据回调失败",null);
    }
    public static Result misserror(){
        return new Result(Constants.CODE_400,"服务器数据响应失败",null);
    }
    public static Result MissInfoerror(){
        return new Result(Constants.CODE_900,"学生数据异常",null);
    }
    public static Result Requestrror(){
        return new Result(Constants.CODE_600,"数据库信息查无此人",null);
    }
    public static Result ResSuccess(String data){
        return new Result(Constants.CODE_600,"核酸检测成功",data);
    }
    public static Result ResError(String data){
        return new Result(Constants.CODE_600,"核酸检测失败",data);
    }
    public static Result ResAck(String data){
        return new Result(Constants.CODE_600,"ack===>invalid",data);
    }
    public static Result ResUser(String data){
        return new Result(Constants.CODE_999,"Null point exception===>invalid",data);
    }
    public static Result ResUserpd(String data){
        return new Result(Constants.CODE_888,"PD ===> invalid",data);
    }
    public static Result ResUserLACC(String data){
        return new Result(Constants.CODE_07927,"PD ====> Access",data);
    }
    public static Result ResUserTime(String data){
        return new Result(Constants.CODE_07928,"Time valid ==>Throws TimeException===> please try QrCode again",data);
    }
    public static Result ResUserIsacid(String data) {
        return new Result(Constants.CODE_07922,"此人核酸信息异常 |请联系辅导员 获取详情",data);
    }
    public static Result ResUserAckError(String data) {
        return new Result(Constants.CODE_000,"ACK NUll ===>valid",data);
    }
    public static Result ResUserIsAcidAccess(String data) {
        return new Result(Constants.CODE_07921,"UserMata No Valid",data);
    }
    public static Result ResUserResponseError(String data, String hsperson) {
        return new Result(Constants.CODE_07929,"Prams Valid null",data);
    }
}
