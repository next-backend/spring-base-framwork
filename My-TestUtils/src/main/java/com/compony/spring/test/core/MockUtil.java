package com.compony.spring.test.core;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Iterator;
import java.util.Map;

public class MockUtil {

    public static final String ENCODING_UTF8 = "UTF-8";
    public static final String JSON = "json";

    public static String mockGet(MockMvc mvc, String uri) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.get(uri, JSON).characterEncoding(ENCODING_UTF8)
                .contentType(MediaType.APPLICATION_JSON)).andReturn()
                .getResponse().getContentAsString();
    }

    public static void mockPost(MockMvc mvc, String uri) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(uri, JSON).characterEncoding(ENCODING_UTF8)
                .contentType(MediaType.APPLICATION_JSON);
        mvc.perform(builder).andDo(MockMvcResultHandlers.print());
    }

    public static void mockPost(MockMvc mvc, String uri, Map<String, String> params) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(uri, JSON).characterEncoding(ENCODING_UTF8)
                .contentType(MediaType.APPLICATION_JSON);
        if (params != null) {
            Iterator<Map.Entry<String, String>> iter = params.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, String> entry = iter.next();
                String key = entry.getKey();
                String val = entry.getValue();
                builder.param(key, val);
            }
        }
        mvc.perform(builder).andReturn().getResponse().getContentAsString();
    }

    public static void mockPost(MockMvc mvc, String uri, Object o) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(uri, JSON).characterEncoding(ENCODING_UTF8)
                .contentType(MediaType.APPLICATION_JSON).content(com.alibaba.fastjson.JSON.toJSONString(o));
        mvc.perform(builder).andReturn().getResponse().getContentAsString();
    }
}