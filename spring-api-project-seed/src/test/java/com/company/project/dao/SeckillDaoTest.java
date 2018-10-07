package com.company.project.dao;

import com.alibaba.fastjson.JSON;
import com.company.project.entity.Seckill;
import com.compony.spring.test.core.TaskRunner;
import com.compony.spring.test.core.TaskUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 配置spring和junit整合,junit启动时加载springIOC容器
 * spring-test,junit
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SeckillMapper seckillMapper;

    @Test
    public void testQueryById() throws Exception {
        final long id = 1000;
        TaskUtil.runTask(100, new TaskRunner() {
            @Override
            protected void call() {
                Seckill seckill = seckillMapper.queryById(id);
                log.info(JSON.toJSONString(seckill));
            }
        });
    }

    @Test
    public void testQueryAll() throws Exception {
        //Parameter 'offset' not found. Available parameters are [0, 1, param1, param2]
        // java没有保存形参的记录:queryAll(int offet,int limit) ->queryAll(arg0,arg1)
        List<Seckill> seckills = seckillMapper.queryAll(0, 100);
        for (Seckill seckill : seckills) {
            log.info(JSON.toJSONString(seckill));
        }
    }

    @Test
    public void testReduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = seckillMapper.reduceNumber(1000L, killTime);
        log.info("updateCount=" + updateCount);
    }

}