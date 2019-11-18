import cn.hutool.core.lang.Console;
import com.crossyf.practice.HutoolApplication;
import com.crossyf.practice.mapper.UserMapper;
import com.crossyf.practice.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Created by YangFan.
 * @date 2019/11/18
 * 功能:
 */
@SpringBootTest(classes = HutoolApplication.class)
@RunWith(SpringRunner.class)
public class TestMybatis {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        System.out.println(("----- selectAll method test ------"));
       User user = userMapper.selectUser("crossyf");
//        Assert.assertEquals(1, userList.size());
//        userList.forEach(System.out::println);
        Console.log(user.toString());

    }
}
