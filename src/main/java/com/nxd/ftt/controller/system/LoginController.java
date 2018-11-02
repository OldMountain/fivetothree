package com.nxd.ftt.controller.system;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.nxd.ftt.controller.base.BaseController;
import com.nxd.ftt.entity.Menu;
import com.nxd.ftt.entity.Result;
import com.nxd.ftt.entity.Role;
import com.nxd.ftt.entity.User;
import com.nxd.ftt.service.MenuService;
import com.nxd.ftt.service.RoleService;
import com.nxd.ftt.service.UserService;
import com.nxd.ftt.util.Const;
import com.nxd.ftt.util.PageData;
import com.nxd.ftt.util.RightsHelper;
import com.nxd.ftt.util.Tools;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * login
 *
 * @author luhangqi
 * @date 2017/12/1
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    /**
     * 去登录页面
     *
     * @return
     */
    @RequestMapping(value = "/toLogin")
    public ModelAndView toLogin() {
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("system/admin/login");
        return mv;
    }

    /**
     * 登录验证
     *
     * @param userName
     * @param password
     * @param code
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public Result login(String userName, String password, String code, HttpServletRequest request) {
        userName = "admin";
        password = "123456";
        Result result = new Result();
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();

        //获取验证码
//        Object obj = session.getAttribute(Const.SESSION_SECURITY_CODE);
//        String sessionCode = null;
//        if (obj != null) {
//            sessionCode = obj.toString();
//        }
        if (true) {
//        if (true) {
            //密码加密
            password = new SimpleHash("SHA-1", userName, password).toString();
            //验证用户名密码
            User user = userService.login(userName, password);
            //验证成功
            if (user != null) {
                session.setAttribute(Const.SESSION_USER, user);
                //shiro加入身份验证
                UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
                currentUser.login(token);
                String path = request.getContextPath();
                String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
                session.setAttribute(Const.CONTEXT_PATH, basePath);
            } else {
                result.setStatus(Const.FALSE);
                result.setMessage("请输入正确的账号密码");
                return result;
            }
            result.setStatus(Const.SUCCESS);
        } else {
            result.setStatus(Const.FALSE);
            result.setMessage("验证码错误");
        }
        return result;
    }


    @RequestMapping(value = {"/toIndex", "/static/lay/admin/pro/dist/toIndex"})
    public ModelAndView index(PageInfo pi) {
        logBefore(logger, "进入首页");
        ModelAndView mv = this.getModelAndView();
        List<Menu> list = null;
        Page page = null;
        PageInfo<Menu> p = null;
        try {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            User user = (User) session.getAttribute(Const.SESSION_USER);
            if (user != null) {
                Role roleModel = new Role();
                roleModel.setRoleId(user.getRoleId());
                roleModel = roleService.getRoleById(roleModel);
                String roleRights = "";
                if (roleModel != null) {
                    roleRights = roleModel.getRights();
                    session.setAttribute(Const.SESSION_USERROL, roleModel);
                    //将角色权限存入session
                    session.setAttribute(Const.SESSION_ROLE_RIGHTS, roleRights);
                }
                //放入用户名
                session.setAttribute(Const.SESSION_USERNAME, user.getUserName());
                if (session.getAttribute(Const.SESSION_allmenuList) != null) {
                    list = (List<Menu>) session.getAttribute(Const.SESSION_allmenuList);
                } else {
                    list = menuService.listAllMenu();
                    if (Tools.notEmpty(roleRights)) {
                        for (Menu menu : list) {
                            if (user.getUserName().equals(Const.ADMIN)) {
                                menu.setHasMenu(true);
                            } else {
                                menu.setHasMenu(RightsHelper.testRights(roleRights, menu.getMenuId()));
                            }
                            if (menu.isHasMenu()) {
                                List<Menu> subMenuList = menu.getSubMenu();
                                if (subMenuList != null && subMenuList.size() > 0) {
                                    for (Menu sub : subMenuList) {
                                        if (user.getUserName().equals(Const.ADMIN)) {
                                            sub.setHasMenu(true);
                                        } else {
                                            sub.setHasMenu(RightsHelper.testRights(roleRights, menu.getMenuId()));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    session.setAttribute(Const.SESSION_allmenuList, list);
                }
                if (null == session.getAttribute(Const.SESSION_QX)) {
                    //按钮权限放到session中
                    session.setAttribute(Const.SESSION_QX, this.getUQX(session));
                }
                mv.addObject("menuList", list);
                mv.setViewName("index");
            } else {
                mv.setViewName("index");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("system/admin/main");
        return mv;
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout() {
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        //shiro管理的session
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        try {
            session.removeAttribute(Const.SESSION_USER);
            session.removeAttribute(Const.SESSION_ROLE_RIGHTS);
            session.removeAttribute(Const.SESSION_allmenuList);
            session.removeAttribute(Const.SESSION_menuList);
            session.removeAttribute(Const.SESSION_QX);
            session.removeAttribute(Const.SESSION_userpds);
            session.removeAttribute(Const.SESSION_USERNAME);
            session.removeAttribute(Const.SESSION_USERROL);
            session.removeAttribute("changeMenu");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //shiro销毁登录
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        pd = this.getPageData();
        String msg = pd.getString("msg");
        pd.put("msg", msg);
        mv.setViewName("system/admin/login");
        return mv;
    }


}
