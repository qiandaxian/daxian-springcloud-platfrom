package com.courier.sdk.core;

/**
 * @author qiandaxian
 * Http标准状态码的枚举类
 */
public enum ResultCodeEnum {
    SUCCESS("200","成功!"),
    BAD_REQUEST("400","参数有误"),
    UNAUTHORIZED("401","签名校验失败"),
    NOT_FOUND("404","接口不存在"),
    METHOD_NOT_ALLOWED("405","权限不足"),
    ERROR("500","服务器内部错误");

    private String code;

    private String desc;

    ResultCodeEnum(String code,String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
