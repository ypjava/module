package xyz.yp.module.console.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.yp.module.qx.service.UserService;

@Controller
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authc/admin/index", method = RequestMethod.GET)
    public @ResponseBody Object testAdminIndex(String userName, String password) {
        logger.info("进入testAdminIndex方法");

        return "success";
    }

}
