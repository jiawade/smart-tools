package com.tool.kit.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public class JacksonUtils {
	
	private static final ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	}


	public static Map<String,Object> convertJsonToMap(String jsonString){
		Map<String,Object> map = new HashMap<>();
		try {
			map = mapper.readValue(jsonString, Map.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static JsonNode parseStringToJsonNode(String jsonStr) {
		try {
			return mapper.readTree(jsonStr);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			// Add ERROR here
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public static <T> T fromJson(String json, Class<T> clazz) {
		T object = null;
		try {
			object = mapper.readValue(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
	public static <T> T fromJson(JsonNode json, Class<T> clazz) {
		T object = null;
		try {
			object = mapper.readValue(json.toString(), clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	/**
	 *
	 * @param jsonNode	需要转换的JsonNode
	 * @param type		转换成的List<type>
	 * @return T
	 * @author linzhongxiu
	 */

	public static <T> T convertJsonNodeToList(JsonNode jsonNode,Class type){

		ArrayList list = new ArrayList();
		try {
			if (jsonNode==null){
				return null;
			}
			list = (ArrayList<T>)mapper.readValue(jsonNode.toString(),mapper.getTypeFactory().constructParametricType(ArrayList.class, type));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (T)list;


	}
	/**
	 *
	 * @param jsonString	需要转换的JsonString
	 * @param type		转换成的List<type>
	 * @return T
	 * @author linzhongxiu
	 */

	public static <T> T convertJsonNodeToList(String jsonString,Class type){
		ArrayList list = new ArrayList();
		try {
			list = (ArrayList<T>)mapper.readValue(jsonString,mapper.getTypeFactory().constructParametricType(ArrayList.class, type));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (T)list;


	}

	private JacksonUtils() {

	}

	public static <T> String toJson(T obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}


	public static <T> T fromJson(String json, TypeReference<T> reference) {
		try {
			return mapper.readValue(json, reference);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	public static <T> T fromTree(String json){
		JsonFactory factory = new JsonFactory();
		try {
			JsonParser  parser  = factory.createParser(json);
			return mapper.readTree(parser);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

		return null;
	}

}
