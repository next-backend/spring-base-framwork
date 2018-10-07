package tk.mybatis.springboot.test;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.compony.spring.test.core.TaskRunner;
import com.compony.spring.test.core.TaskUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.springboot.Application;
import tk.mybatis.springboot.model.Country;
import tk.mybatis.springboot.service.CountryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuzh
 * @since 2017/9/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
public class CountryServiceTest {

    @Resource
    private CountryService countryService;

    @Test
    public void test() throws InterruptedException {
        TaskUtil.runTask(100, new TaskRunner() {
            @Override
            protected void call() {
                Country country = new Country();
                List<Country> all = countryService.getAll(country);
                System.out.printf(JSON.toJSONString(all));
            }
        });
    }
}
