package com.company.project.web;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

public class SeckillWebTest extends BaseWebTest {

    private static final String RESOURCE_PATH = "/seckill";

    @Test
    public void exposer() throws Exception {
        this.postRunable(RESOURCE_PATH + "/1001/exposer", null, 1000);
    }

    @Test
    public void list() throws Exception {
        Map<String, Object> params = Maps.newHashMap();
        params.put("pageNum", 1);
        params.put("pageSize", 10);
        this.post("/success/killed/list", params);
    }

    @Test
    public void time() throws Exception {
        this.get(RESOURCE_PATH + "/time/now");
    }
}
