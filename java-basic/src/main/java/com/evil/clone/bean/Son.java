package com.evil.clone.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Son
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-16
 */
@Getter
@Setter
@ToString
public class Son implements Cloneable{
    private String sex;
    private  String name;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
