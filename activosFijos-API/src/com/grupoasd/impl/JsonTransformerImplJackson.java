package com.grupoasd.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import com.grupoasd.dao.JsonTransformer;

@Component
public class JsonTransformerImplJackson implements JsonTransformer{

	@Override
	public String toJson(Object data) {
		try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(data);
        } catch ( IOException ex) {
            throw new RuntimeException(ex);
        }
	}

	@Override
	public Object fromJson(String json, Class clazz) {
		try {
            ObjectMapper objectMapper = new ObjectMapper();
 
            return objectMapper.readValue(json, clazz);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
	}
	
	
	
	

}
