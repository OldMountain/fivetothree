package com.nxd.ftt.interceptor;

import com.nxd.ftt.common.util.Tools;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 李欣彤 on 16/04/26.
 */
public class PjaxHandlerInterceptor extends HandlerInterceptorAdapter {

    /**
     * 此类用于拦截接口请求
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String isPJAX = request.getHeader("X-PJAX");
        if (isPJAX==null && Tools.isEmpty(isPJAX)){
            String path = request.getServletPath();
            String suffix = path.substring(path.lastIndexOf(".")+1,path.length());
            //判断是否弹出框请求
            if (Tools.notEmpty(suffix) && suffix.equals("modal")){
                request.getRequestDispatcher("toIndex");
            }else{
                path = path.substring(0,1).equals("/")?path.substring(1):path;
                //获取地址栏参数
                if(!Tools.isEmpty(request.getQueryString())){
                    path += "?" + request.getQueryString();
                }
                request.setAttribute("INDEX_BACK_URL",path);
                //发回主页 并重新加载内容
                request.getRequestDispatcher("/toIndex").forward(request,response);
            }
            return false;
        }
        return true;
    }
}
