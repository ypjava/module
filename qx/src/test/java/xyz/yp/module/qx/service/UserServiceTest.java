package xyz.yp.module.qx.service;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.yp.module.qx.domain.User;

import java.util.HashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-qx.xml"})
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testFindByParams() {
        PageInfo<User> page = userService.findByParams(new HashMap<String, Object>(), 1, 10);
        for (User user : page.getList()) {
            System.out.println(user.getId() + " | " + user.getUserName());
        }
    }

    @Test
    public void testCreate() {
        User user = new User();
        user.setUserName("测试用户");
        // user.setPassword("123456");
        user.setCreateTime("2018-01-19 00:00:00");
        userService.create(user);

        System.out.println(user.getId());
    }

}
