package com.courier.sdk.core;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qiandaxian
 * 统一的接口返回对象
 */

public class Result extends JSONObject {
    private Head head;
    private Object data;

    public Result() {
    }

    /**
     * JSON封装的实体扩展
     *
     * @param key
     * @param value
     * @return
     */
    public Result set(String key, Object value) {
        if (value != null) {
            super.put(key, value);
        }
        return this;
    }

    public Head getHead() {
        return head;
    }

    public Result setHead(Head head) {
        return set("head",head);
    }

    public Result setHead(String code,String desc) {
        return set("head",new Head(code,desc));
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        return set("data",data);

    }
}
