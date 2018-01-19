package xyz.yp.module.console.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.yp.module.core.wrapper.AbstractBaseActionWrapper;
import xyz.yp.module.qx.domain.User;
import xyz.yp.module.qx.service.UserService;

@Controller
public class UserController extends AbstractBaseController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/find")
    public void find(final String userName) {
        new AbstractBaseActionWrapper(this.response) {
            public Object doAction() {
                User user = userService.findByUserName(userName);
                throw new RuntimeException("测试异常");
                // return user;
            }
        };
    }

}
