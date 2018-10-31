package com.courier.sdk.utils;

import com.alibaba.fastjson.JSONObject;
import com.courier.sdk.core.Head;
import com.courier.sdk.core.Result;
import com.courier.sdk.core.ResultCodeEnum;
import com.github.pagehelper.PageInfo;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import java.util.Map;

/**
 * 响应结果生成工具
 * @author qiandaxian
 */
@SuppressWarnings("rawtypes")
public class ResultUtil {

	public static Result getSuccessResult() {
		Head head = new Head(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getDesc());
		return new Result().setHead(head);
	}

	public static Result getSuccessResult(Object data) {
		return getSuccessResult(ResultCodeEnum.SUCCESS.getCode(), data);
	}

	public static Result getSuccessResult(String message, Object data) {

		Head head = new Head(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getDesc());
		Result result = new Result().setHead(head);
		/*
		 * 返回信息结果集合,如果是集合默认key值为'list' {'list' : list集合}
		 */
		result = getResultData(result, data);
		return result;
	}

	/**
	 * 失败 错误码 500
	 * 
	 * @return
	 */
	public static Result getFailResult() {
		return getFailResult(ResultCodeEnum.ERROR.getCode());
	}

	/**
	 * 失败 错误码 500
	 * 
	 * @param message
	 * @return
	 */
	public static Result getFailResult(String message) {
		Head head = new Head(ResultCodeEnum.ERROR.getCode(), message);
		return new Result().setHead(head);
	}

	/**
	 * 服务器内部错误 错误码 4500
	 * 
	 * @param
	 * @return
	 */
	public static Result getErrorResult() {
		Head head = new Head(ResultCodeEnum.ERROR.getCode(), ResultCodeEnum.ERROR.getDesc());
		return new Result().setHead(head);
	}

	/**
	 * 服务器内部错误 错误码 500
	 * 
	 * @param message
	 * @return
	 */
	public static Result getErrorResult(String message) {
		Head head = new Head(ResultCodeEnum.ERROR.getCode(), message);
		return new Result().setHead(head);
	}

	/**
	 * 服务器内部错误 错误码 500
	 * @param format	格式化输出消息，类似self4j
	 * @param arguments
	 * @return
	 */
	public static Result getErrorResult(String format, Object... arguments) {
		FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
		String msg = ft.getMessage();

		Head head = new Head(ResultCodeEnum.ERROR.getCode(), msg);
		return new Result().setHead(head);
	}

	/**
	 * 服务器内部错误 错误码 400
	 * @param format	格式化输出消息，类似self4j
	 * @param arguments
	 * @return
	 */
	public static Result getErrorResult(String errorCode, String format, Object... arguments) {
		FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
		String msg = ft.getMessage();

		Head head = new Head(errorCode, msg);
		return new Result().setHead(head);
	}


	/**
	 * 判定返回结果是否成功
	 * 
	 * @param result
	 * @return
	 */
	public static boolean isSuccess(Result result) {
		if (ResultCodeEnum.SUCCESS.getCode().equals(result.getHead().getCode())) {
			return true;
		}

		return false;
	}

	/**
	 * 请求成功返回信息结果集合,如果是集合默认key值为'list' {'list' : list集合}
	 * 
	 * @param result
	 * @param
	 * @param
	 * @return
	 */
	private static Result getResultData(Result result, Object objectData) {
		if (objectData == null) {
			return result;
		}

		if (objectData instanceof PageInfo) {
			pagehandler(result, (PageInfo) objectData);
		} else if (objectData instanceof JSONObject) {
			// 实体对象都继承自JSONObject，而JSONObject 实现了map接口，所以能这么写
			result.put("data", (Map) objectData);
		} else {
			result.put("data", objectData);
		}

		return result;
	}

	private static void pagehandler(Result result, PageInfo page) {
		result.put("data", page);
	}

}