package xyz.yp.module.core.wrapper;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class AppLoginedActionWraper extends AbstractBaseActionWrapper {
    private static Logger logger = LoggerFactory.getLogger(AppLoginedActionWraper.class);
    public AppLoginedActionWraper(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }


    private String getSignParam(String name) {
        String value = _req.getParameter(name);
        if (StringUtils.isEmpty(value)) {
            value = _req.getHeader(name);
        }
        return value;
    }

    @Override
    public Object doAction()  {
    	if(_req.getSession()==null){
    		logger.error("session为空");
    		return null;
    	}
        Map userData = (Map) _req.getSession().getAttribute("userData");
        if(userData!=null)
        	userData= (Map) userData.get("userData");
        String userId = (String)_req.getSession().getAttribute("userId");
        if(userData!=null&&userId!=null)
        	return doAction(userData, userId);
        else
        	return null;
//        try {
//			userData= (Map) userData.get("userData");
//		} catch (Exception e) {
//			logger.error("session为空");
//			logger.error(e.getMessage(),e);
//		}
        
    }


    public abstract Object doAction(Map userData, String userId) ;

}
