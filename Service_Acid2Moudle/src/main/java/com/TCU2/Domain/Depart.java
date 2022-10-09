package com.TCU2.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Depart implements Serializable {
    Integer ID;
    String name;
    Integer parentid;

}
