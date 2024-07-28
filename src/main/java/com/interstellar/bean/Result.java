package com.interstellar.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * 向前端返回信息封装
 * @param <T> 可变类型
 */
@Setter
@Getter
public class Result<T> {
    /**
     * 返回信息
     */
    private String msg;

    /**
     * 数据是否正常请求
     */
    private boolean success;

    /**
     * 具体返回的数据
     */
    private T detail;

    public boolean isSuccess() {
        return success;
    }

}
