package com.TCU.Domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @TableName hsperson
 */
@TableName(value ="hsperson")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hsperson implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId
    private String id;

    /**
     * 性别
     */
    private String Gender;
    /**
     * 姓名
     */
    private String name;
    /**
     * 名族
     */
    private String nation;
    /**
     * 政治面貌
     */
    private String politicalstatus;
    /**
     * 身份证
     */
    private String identitycard;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 家庭住址
     */
    private String homeaddress;
    /**
     * 学生种类
     */
    private String studentcategory;
    /**
     * 学籍状态
     */
    private String schoolroll;
    /**
     * 在校状态
     */
    private String schoolstatus;
    /**
     * 学院
     */
    private String department;
    /**
     * 年级
     */
    private String grade;
    /**
     * 专业
     */
    private String major;
    /**
     * 班级
     */
    private String classroom;
    /**
     * 宿舍
     */
    private String dormitory;
    /**
     * 宿舍房间
     */
    private String dormitoryroom;
    /**
     * 宿舍床位
     */
    private String dormitorybed;
    /**
     * 居住状态
     */
    private String livingstatus;
    /**
     * 辅导员
     */
    private String counselor;

    /**
     * 核酸检测时间
     */
    private String acidtime;
    /**
     * 辅导员电话
     */
    private String counselorphone;
}