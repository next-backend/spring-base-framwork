package com.company.project.service;

import com.alibaba.fastjson.JSON;
import com.company.project.dto.Exposer;
import com.company.project.dto.SeckillExecution;
import com.company.project.entity.Seckill;
import com.company.project.exception.RepeatKillException;
import com.company.project.exception.SeckillCloseException;
import com.compony.spring.test.core.TaskRunner;
import com.compony.spring.test.core.TaskUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void testGetSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", JSON.toJSONString(list));
    }

    @Test
    public void testGetById() throws Exception {
        final long id = 1000;
        TaskUtil.runTask(100, new TaskRunner() {
            @Override
            protected void call() {
                Seckill seckill = seckillService.getById(id);
                logger.info(JSON.toJSONString(seckill));
            }
        });
    }


    //集成测试代码完整逻辑,注意可重复执行.
    @Test
    public void testSeckillLogic() throws Exception {
        TaskUtil.runTask(10, new TaskRunner() {
            @Override
            protected void call() {
                long id = 1001;
                Exposer exposer = seckillService.exportSeckillUrl(id);
                if (exposer.isExposed()) {
                    logger.info("exposer={}", exposer);
                    long phone = 13502171127L;
                    String md5 = exposer.getMd5();
                    try {
                        SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
                        logger.info("result={}", execution);
                    } catch (RepeatKillException e) {
                        logger.error(e.getMessage());
                    } catch (SeckillCloseException e) {
                        logger.error(e.getMessage());
                    }
                } else {
                    //秒杀未开启
                    logger.warn("exposer={}", exposer);
                }
            }
        });
    }

    @Test
    public void executeSeckillProcedure() throws InterruptedException {
        TaskUtil.runTask(10, new TaskRunner() {
            @Override
            protected void call() {
                long seckillId = 1001;
                long phone = 1368011101;
                Exposer exposer = seckillService.exportSeckillUrl(seckillId);
                if (exposer.isExposed()) {
                    String md5 = exposer.getMd5();
                    SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
                    logger.info(execution.getStateInfo());
                }
            }
        });
    }
}