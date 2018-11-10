package com.nxd.ftt.service.impl;

import com.google.gson.Gson;
import com.nxd.ftt.dao.MenuDao;
import com.nxd.ftt.entity.Menu;
import com.nxd.ftt.entity.Tree;
import com.nxd.ftt.entity.User;
import com.nxd.ftt.service.MenuService;
import com.nxd.ftt.service.RoleService;
import com.nxd.ftt.util.Const;
import com.nxd.ftt.util.RightsHelper;
import com.nxd.ftt.util.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * MenuServiceImpl
 *
 * @author OldMountain
 * @date 2017/12/4
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private RoleService roleService;

    @Override
    public List<Menu> getCurrentMenu() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        List<Menu> list;
        if (session.getAttribute(Const.SESSION_allmenuList) != null) {
            list = (List<Menu>) session.getAttribute(Const.SESSION_allmenuList);
        } else {
            list = this.listAllMenu();
            session.setAttribute(Const.SESSION_allmenuList, list);
        }
        return list;
    }

    @Override
    public void resetCurrentMenu() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        List<Menu> list = this.listAllMenu();
        session.setAttribute(Const.SESSION_allmenuList, list);
    }

    @Override
    public List<Menu> listAllMenu() {
        User user = SystemUtil.getCurrentUser();
        List<Menu> rl;
        Menu menu = new Menu();
        menu.setParentId("0");
        rl = menuDao.select(menu);
        for (Menu m : rl) {
            getSubList(m, user.getRights());
        }
        return rl;
    }

    public void getSubList(Menu parentMenu, String rights) {
        parentMenu.setHasMenu(RightsHelper.testRights(rights, parentMenu.getMenuId()));
        if (parentMenu.isHasMenu()) {
            List<Menu> subList = menuDao.getSubList(parentMenu.getMenuId());
            parentMenu.setSubMenu(subList);
            for (Menu m : subList) {
                getSubList(m, rights);
            }
        }
    }

    @Override
    public List<Menu> getCurrentUserMenu() {
        User user = SystemUtil.getCurrentUser();
        List<Menu> rl = new ArrayList<>();

        return rl;
    }

    @Override
    public List<Menu> listParentAll() {
        Menu menu = new Menu();
        menu.setParentId("0");
        return menuDao.select(menu);
    }

    @Override
    public List<Menu> selectSubMenuByParentId(String menuId) {
        Menu menu = new Menu();
        menu.setParentId(menuId);
        return menuDao.select(menu);
    }

    @Override
    public String listTreeMenu() {
        List<Tree> trees = new ArrayList<>();
        trees.add(new Tree("0", "-1", Const.ROOT_MENU_NAME, true, true));
        trees.addAll(menuDao.getTree());
        return new Gson().toJson(trees);
    }

    @Override
    public Menu findById(Integer menuId) {
        return menuDao.findById(menuId);
    }

    @Override
    public int save(Menu menu) {
        int order = this.findMaxOrder(Integer.parseInt(menu.getParentId()));
        menu.setMenuOrder(order + 1);
        return menuDao.insert(menu);
    }

    @Override
    public int modify(Menu menu) {
        return menuDao.update(menu);
    }

    @Override
    public int findMaxOrder(Integer parentId) {
        return menuDao.findMaxOrder(parentId);
    }


}
