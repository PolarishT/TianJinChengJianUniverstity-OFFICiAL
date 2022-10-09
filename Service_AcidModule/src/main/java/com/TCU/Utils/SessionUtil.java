package com.TCU.Utils;


import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Session 常用工具类
 * @author zzt
 */
public class SessionUtil {

    /**
     * 获取request
     * @return
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes==null? null : requestAttributes.getRequest();
    }

    /**
     * 获取session
     * @return
     */
    public static HttpSession GetSession(){
        return getRequest().getSession(false);
    }

    /**
     * 获取真实路径
     * @return
     */
    public static String GetRealRootPath(){
        return getRequest().getServletContext().getRealPath("/");
    }

    /**
     * 获取ip
     * @return
     */
    public static String getIp() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if(servletRequestAttributes!=null){
            HttpServletRequest request = servletRequestAttributes.getRequest();
            return request.getRemoteAddr();
        }
        return null;
    }

    /**
     * 获取session中的Attribute
     * @param name
     * @return
     */
    public static Object GetSessionAttribute(String name){
        HttpServletRequest request = getRequest();
        return request == null?null:request.getSession().getAttribute(name);
    }

    /**
     * 设置session的Attribute
     * @param name
     * @param value
     */
    public static void SetSessionAttribute(String name,Object value){
        HttpServletRequest request = getRequest();
        if(request!=null){
            request.getSession().setAttribute(name,value);
        }
    }

    /**
     * 获取request中的Attribute
     * @param name
     * @return
     */
    public static Object GetRequestAttribute(String name){
        HttpServletRequest request = getRequest();
        return request == null?null:request.getAttribute(name);
    }

    /**
     * 设置request的Attribute
     * @param name
     * @param value
     */
    public static void SetRequestAttribute(String name,Object value){
        HttpServletRequest request = getRequest();
        if(request!=null){
            request.setAttribute(name, value);
        }
    }

    /**
     * 获取上下文path
     * @return
     */
    public static String GetContextPath() {
        return getRequest().getContextPath();
    }

    /**
     * 删除session中的Attribute
     * @param name
     */
    public static void RemoveSessionAttribute(String name) {
        getRequest().getSession().removeAttribute(name);
    }

}