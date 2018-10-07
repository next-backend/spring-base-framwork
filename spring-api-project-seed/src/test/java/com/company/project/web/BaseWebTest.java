package com.company.project.web;

import com.compony.spring.test.core.MockUtil;
import com.compony.spring.test.core.TaskRunner;
import com.compony.spring.test.core.TaskUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/spring-web.xml")
@WebAppConfiguration
public class BaseWebTest {
    public MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    public void get(String uri) throws Exception {
        MockUtil.mockGet(mockMvc, uri);
    }

    public void post(String uri, Map<String, String> params) throws Exception {
        MockUtil.mockPost(mockMvc, uri, params);
    }

    public void postRunable(String uri, Map<String, String> params, int num) throws Exception {
        TaskUtil.runTask(num, new TaskRunner() {
            @Override
            protected void call() {
                try {
                    MockUtil.mockPost(mockMvc, uri, params);
                } catch (Exception e) {
                    log.error("error: {}", e.getMessage(), e);
                }
            }
        });
    }

    public void post(String uri, Object o) throws Exception {
        MockUtil.mockPost(mockMvc, uri, o);
    }

    public void postRunable(String uri, Object o, int num) throws Exception {
        TaskUtil.runTask(num, new TaskRunner() {
            @Override
            protected void call() {
                try {
                    MockUtil.mockPost(mockMvc, uri, o);
                } catch (Exception e) {
                    log.error("error: {}", e.getMessage(), e);
                }
            }
        });
    }
}