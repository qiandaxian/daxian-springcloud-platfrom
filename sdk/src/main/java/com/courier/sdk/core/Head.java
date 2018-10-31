package com.courier.sdk.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qiandaxian
 * 统一的消息头定义
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Head {
	//http标准状态码
	private String code;
	//提示信息信息
	private String msg;
}
