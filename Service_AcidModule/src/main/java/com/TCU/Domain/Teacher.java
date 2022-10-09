package com.TCU.Domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName teacher
 */
@TableName(value ="teacher")
@Data
public class Teacher implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId
    private String id;
    /**
     * 姓名
     */
    private String Name;
    /**
     * 性别
     */
    private String Gender;

    /*
     * 手机号
     */
    private String Phone;

    /**
     * 所属学院
     */
    private String Department;
    /**
     * 核酸检测时间
     */
    private String acidtime;
}