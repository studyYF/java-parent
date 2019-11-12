import com.crossyf.practice.springboot.FtpConfig;
import com.crossyf.practice.springboot.WebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Created by YangFan.
 * @date 2019/11/12
 * 功能:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class ConfigTest {

    @Autowired
    private FtpConfig ftpConfig;

    @Value("${image.ftp.username}")
    private String username;

    @Test
    public void testConfiguration() {
        System.out.println(ftpConfig.getPassword());
        System.out.println(ftpConfig.getUsername());
        System.out.println(username);
    }
}
