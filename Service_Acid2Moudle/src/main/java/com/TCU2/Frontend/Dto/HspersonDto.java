package com.TCU2.Frontend.Dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @author zzt
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HspersonDto  implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String phone;
    private String grade;
    private String department;
    private String major;
    private String dormitory;
    private String dormitorybed;
    private String acidtime;
}



