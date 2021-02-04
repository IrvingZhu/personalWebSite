/**
 * 
 */
package com.zrz.personalWeb.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zrz
 *
 */


public class UserLoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {	
		HttpSession sess = request.getSession();
		Object uid = sess.getAttribute("uid");
		
		if(uid != null) {
//			response.sendRedirect(request.getContextPath() + "/login.html");
			return true;
		}
		
		return false;
	}
	

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        
    }

}
