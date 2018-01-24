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
public class IndexController extends AbstractBaseController {
    private Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public void login(String userName, String password, String jsonpCallback) {
        new AbstractBaseActionWrapper(request, response) {
            @Override
            public Object doAction() {
                UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
                Subject subject = SecurityUtils.getSubject();

                subject.login(token);
                User user = userService.findByUserName(userName);
                return user;
            }
        };
        /*UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
            User user = userService.findByUserName(userName);
            return user;
        } catch (UnknownAccountException e) {
            logger.error("用户不存在异常");
        } catch (IncorrectCredentialsException e) {
            logger.error("密码错误异常");
        } catch (ExcessiveAttemptsException e) {
            logger.error("登陆过多异常");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;*/
    }

    @RequestMapping(value = "/home/unauthorized", method = RequestMethod.GET)
    public @ResponseBody Object unauthorized(String userName, String password) {
        return "没有授权";
    }

}
