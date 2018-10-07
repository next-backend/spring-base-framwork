package com.company.project.dao.cache;

import com.company.project.dao.SeckillMapper;
import com.company.project.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest {
    private long id = 1001;
    @Resource
    private RedisDao redisDao;

    @Resource
    private SeckillMapper seckillMapper;

    @Test
    public void testSeckill() throws Exception {
        //get and put
        Seckill seckill = redisDao.getSeckill(id);
        if (seckill == null) {
            seckill = seckillMapper.queryById(id);
            if (seckill != null) {
                String result = redisDao.putSeckill(seckill);
                System.out.println(result);
                seckill = redisDao.getSeckill(id);
                System.out.println(seckill);
            }

        }
    }
}