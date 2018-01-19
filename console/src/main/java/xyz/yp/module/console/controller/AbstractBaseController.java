package xyz.yp.module.console.controller;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import xyz.yp.module.core.utils.ServletUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class AbstractBaseController {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    @ModelAttribute
    public void init(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    /*@ExceptionHandler({AuthorizationException.class})
    public void authorizationExceptionHandler(AuthorizationException e, HttpServletResponse response) {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("code", "404");
        res.put("message", "对不起，您没有该权限");
        ServletUtils.writeToResponse(response, res);
    }

    @ExceptionHandler({Exception.class})
    public void handlerException(Exception e, HttpServletResponse response) {
        e.printStackTrace();
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("code", "500");
        res.put("message", "系统异常");
        ServletUtils.writeToResponse(response, res);
    }*/

}
