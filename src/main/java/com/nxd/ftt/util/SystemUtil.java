package com.nxd.ftt.util;

import com.nxd.ftt.entity.Role;
import com.nxd.ftt.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import java.util.List;

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

    public static boolean isAdmin(){
        User user = getCurrentUser();
        List<Role> roles = user.getRoles();
        for (int i = 0; i < roles.size(); i++) {
            if (Const.ADMIN_ROLE_ID.equals(roles.get(i).getParentId())) {
                return true;
            }
        }
        return false;
    }
}
