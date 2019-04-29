package com.example.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class TestLombok implements Serializable {
    /** 姓名 */
    private String name;
    /** 电话 */
    private String phone;
}
