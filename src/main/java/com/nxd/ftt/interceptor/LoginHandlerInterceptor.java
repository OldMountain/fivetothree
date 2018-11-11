package com.nxd.ftt.interceptor;

import com.nxd.ftt.entity.Menu;
import com.nxd.ftt.util.Const;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 类名称：LoginHandlerInterceptor.java
 * 类描述：
 *
 * @author nxd
 * 作者单位：
 * 联系方式：
 * 创建时间：2015年1月1日
 * @version 1.6
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        if (session != null) {
            List<Menu> menuList = (List<Menu>) session.getAttribute(Const.SESSION_allmenuList);
            for (int i = 0; i < menuList.size(); i++) {
                String url = menuList.get(i).getMenuUrl();
                if (url == null) {
                    continue;
                }
                if (url.startsWith("/") && url.equals(path)) {
                    session.setAttribute("indexUrl", url);
                    break;
                } else if (url.equals(path.substring(1))) {
                    session.setAttribute("indexUrl", url);
                    break;
                }
            }
        }
        return true;
    }
//
}
