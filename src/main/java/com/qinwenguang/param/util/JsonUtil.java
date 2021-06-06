package com.qinwenguang.param.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

/**
 * 通用格式的json 和 实体类  list map之间的转换
 * @author wenguang 2018年12月7日
 */
public class JsonUtil<T> {

	/**
	 * 将Bean转换称json
	 * @param bean 需要转换的bean
	 * @return  返回的json字符串
	 */
	public static <T> String  beanToJson(T bean) {
		String jsonString = null;
		jsonString = JSON.toJSONString(bean);
		return jsonString;
	}
	
	/**
	 * 将json转换成JSONObject类型
	 * @param json 需要转换的json类型
	 * @return JSONObject对象
	 */
	public static JSONObject JsonToBean(String jsonString) {
		JSONObject obj = null;
		obj = JSON.parseObject(jsonString);
		return obj;
	}
	
	/**
	 * 将List转换称json
	 * @param list 需要转换的list
	 * @return
	 */
	public static <T> String listToJson(List<T> list) {
		String jsonString = null;
		jsonString = JSON.toJSONString(list);
		return jsonString;
	}
	
	/**
	 * 将json转换回List<JSONObject>类型
	 * @param json
	 * @return List<JSONObject> ,由getType(key)可获得需要的属性
	 */
	public static List<JSONObject> jsonToList(String jsonString){
		List<JSONObject> list = null;
		list = JSON.parseObject(jsonString,List.class);
		return list;
	}
	
	/**
	 * 将map转换为json字符串
	 * @param map  需要转换的Map类型
	 */
	public static <T> String mapToJson(Map<String,T> map) {
		String jsonString = null;
		jsonString = JSON.toJSONString(map);
		return jsonString;
	}
	
	/**
	 * 将json转换回Map<String,JSONObject> 类型
	 * 注意：字符串必须为{"test1":{"code":1,"msg":"wenguang"}}类型
	 * @param json
	 * @return   Map<String,JSONObject>, 由get获取JSONObject类型
	 */
	public static Map<String,JSONObject> jsonToMap(String jsonString){
		Map<String,JSONObject> map = null;
		map = JSON.parseObject(jsonString,new TypeReference<Map<String, JSONObject>>(){} );
		return map;
	}
}
