package com.czxy.score.intercept;

import com.czxy.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version v 1.0
 * @date 2019/7/25
 */
@Component
public class MyIntercept implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if (requestURI.startsWith("/css") || requestURI.startsWith("/fonts") || requestURI.startsWith("/images") || requestURI.startsWith("/js") || requestURI.contains("index") || requestURI.contains("login") ) {
            return true;
        }

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/index.html");
            return false;
        }

        return true;
    }
}
