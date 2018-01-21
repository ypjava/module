package xyz.yp.module.console.controller;

import com.github.pagehelper.PageInfo;
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
import xyz.yp.module.core.utils.StringUtils;
import xyz.yp.module.core.wrapper.AbstractBaseActionWrapper;
import xyz.yp.module.qx.domain.User;
import xyz.yp.module.qx.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户管理
 */
@Controller
public class UserController extends AbstractBaseController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/find")
    public void find(final String currentPage, final String pageSize) {
        new AbstractBaseActionWrapper(this.response) {
            public Object doAction() {
                Map<String, Object> params = new HashMap<String, Object>();
                PageInfo<User> page = userService.findByParams(params, StringUtils.string2int(currentPage, 1), StringUtils.string2int(pageSize, 10));
                return page;
            }
        };
    }

    @RequestMapping(value = "/user/create")
    public void create(final User user) {
        new AbstractBaseActionWrapper(this.response) {
            public Object doAction() {
                userService.create(user);
                return user;
            }
        };
    }

    @RequestMapping(value = "/user/delete")
    public void delete(final String userId) {
        new AbstractBaseActionWrapper(this.response) {
            public Object doAction() {
                userService.deleteById(userId);
                return "success";
            }
        };
    }


}
