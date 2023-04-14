package com.bestdata.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenyuanheng
 * @version 1.0
 * @date 2020/06/22 11:42
 */
@Data
public class Dog implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private Integer age;
    private String color;

}
