package com.company.project.dao;

import com.company.project.entity.SuccessKilled;
import com.compony.spring.test.core.TaskRunner;
import com.compony.spring.test.core.TaskUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicLong;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledMapper successKilledMapper;

    private AtomicLong atomId = new AtomicLong(1001L);
    private AtomicLong atomPhone = new AtomicLong(13502181181L);

    @Test
    public void testInsertSuccessKilled() throws Exception {
        /*
        第一次:insertCount=1
        第二次:insertCount=0
         */
        long id = 1001L;
        long phone = 13502181181L;
        TaskUtil.runTask(100, new TaskRunner() {
            @Override
            protected void call() {
                long newId = atomId.incrementAndGet();
                long newPhone = atomPhone.incrementAndGet();
                successKilledMapper.insertSuccessKilled(newId, newPhone);
            }
        });
    }

    @Test
    public void testQueryByIdWithSeckill() throws Exception {
        long id = 1001L;
        long phone = 13502181181L;
        SuccessKilled successKilled = successKilledMapper.queryByIdWithSeckill(id, phone);
        System.out.println(successKilled);
//        System.out.println(successKilled.getSeckill());
        /*
        SuccessKilled{seckillId=1001,
        userPhone=13502181181,
        state=0,
        createTime=Wed Oct 07 22:17:11 CST 2015}
         */
    }
}