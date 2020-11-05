package cn.edu.svtcc.interceptor;

import lombok.var;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Daved
 * @title loginInterceptor
 * @description
 * @date 2020/06/14/21:13
 */

public class loginInterceptor implements HandlerInterceptor{
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String url = request.getRequestURI();
    if (url.indexOf("user/login")>=0){
      return true;

    }
    HttpSession session = request.getSession();
    String user = (String) session.getAttribute("user");
    if (user != null){
      return true;
    }
    request.setAttribute("msg","你还没有登录，请先登录");
    request.getRequestDispatcher("/jsp/index.jsp").forward(request,response);
    return false;
  }

  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

  }

  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

  }
}
