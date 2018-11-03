import com.compony.spring.test.core.WebClientUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;

import javax.annotation.Resource;


public class HtmlUnitTest {

    @Resource
    private ApplicationContext context;

    WebTestClient client ;

    @Before
    public void setUp() {
        client = WebTestClient.bindToApplicationContext(context).build() ;
    }

    @Test
    public void testGet() throws Exception {
        WebClientUtil.mockGet(client,"/messages/");
    }

    @Test
    public void testPost() throws Exception {
        WebClientUtil.mockPost(client,"/messages/");
    }
}
