package com.liben.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liben
 * @date 2020/4/16 15:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T       data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
