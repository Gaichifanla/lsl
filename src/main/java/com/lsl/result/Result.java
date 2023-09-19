package com.lsl.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public Result(T data) {
        this.data = data;
        this.code = 1000;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(data);
        result.setCode(200);
        result.setMsg("请求成功");
        return result;
    }

    public static <T> Result<T> success(String msg, T data) {
        Result<T> result = new Result<>(data);
        result.setCode(200);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result fail(int code, String message, T data) {
        Result<T> resultData = new Result<>();
        resultData.setCode(code);
        resultData.setMsg(message);
        resultData.setData(data);
        return resultData;
    }
}
