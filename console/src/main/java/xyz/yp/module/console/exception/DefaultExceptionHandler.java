package xyz.yp.module.console.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        // 返回json格式数据，不是页面
        FastJsonJsonView jsonView = new FastJsonJsonView();
        jsonView.addStaticAttribute("code", "500");
        jsonView.addStaticAttribute("message", e.getMessage());

        ModelAndView mav = new ModelAndView();
        mav.setView(jsonView);
        return mav;
    }

}
