package com.nxd.ftt.util;

import com.nxd.ftt.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * 系统工具类
 *
 * @author luhangqi
 * @date 2018/10/25
 */
public class SystemUtil {

    /**
     * 获取当前用户
     *
     * @return
     */
    public static User getCurrentUser() {
        User user = null;
        try {
            Session session = SecurityUtils.getSubject().getSession();
            user = (User) session.getAttribute(Const.SESSION_USER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
