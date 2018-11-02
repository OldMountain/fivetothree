package com.nxd.ftt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.nxd.ftt.dao.MenuDao;
import com.nxd.ftt.entity.Menu;
import com.nxd.ftt.entity.Role;
import com.nxd.ftt.entity.Tree;
import com.nxd.ftt.entity.User;
import com.nxd.ftt.service.MenuService;
import com.nxd.ftt.service.RoleService;
import com.nxd.ftt.util.Const;
import com.nxd.ftt.util.RightsHelper;
import com.nxd.ftt.util.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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
    public List<Menu> listAllMenu() {
        List<Menu> rl;
        Menu menu = new Menu();
        menu.setParentId("0");
        rl = menuDao.select(menu);
        for (Menu m : rl) {
            menu.setParentId(String.valueOf(m.getMenuId()));
            List<Menu> subList = menuDao.select(menu);
            m.setSubMenu(subList);
        }
        return rl;
    }

    @Override
    public List<Menu> getCurrentUserMenu() {
        User user = SystemUtil.getCurrentUser();
        List<Menu> rl;
        Menu menu = new Menu();
        menu.setParentId("0");
        rl = menuDao.select(menu);
        for (Menu m : rl) {
            menu.setParentId(String.valueOf(m.getMenuId()));
            //权限检测

            List<Menu> subList = menuDao.select(menu);
            m.setSubMenu(subList);
        }
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
    public String listTreeMenu(Role role, int type) {
        List<Menu> rl = null;
        List<Tree> treeNodeHasSub = new ArrayList<>();
        Tree rootTree = new Tree();
        rootTree.setChecked(false);
        rootTree.setpId("-1");
        rootTree.setName(Const.ROOT_MENU_NAME);
        rootTree.setId("0");
        rootTree.setOpen(true);
        treeNodeHasSub.add(rootTree);
        List<Tree> treeNode = new ArrayList<>();
        role = roleService.getRoleById(role);
        String rights = "";
        switch (type) {
            //菜单权限
            case 0:
                rights = role.getRights();
                break;
            //增
            case 1:
                rights = role.getAddQx();
                break;
            //删
            case 2:
                rights = role.getDelQx();
                break;
            //改
            case 3:
                rights = role.getEditQx();
                break;
            //查
            case 4:
                rights = role.getChaQx();
                break;
            default:
                rights = "";
        }
        rl = this.listParentAll();
        for (Menu menu : rl) {
            menu.setHasMenu(RightsHelper.testRights(rights, menu.getMenuId()));
            List<Menu> subList = this.selectSubMenuByParentId(String.valueOf(menu.getMenuId()));
            if (subList != null && subList.size() > 0) {
                for (Menu subMenu : subList) {
                    subMenu.setHasMenu(RightsHelper.testRights(rights, subMenu.getMenuId()));
                    Tree tree = new Tree();
                    tree.setpId(String.valueOf(menu.getMenuId()));
                    tree.setId(String.valueOf(subMenu.getMenuId()));
                    tree.setName(subMenu.getMenuName());
                    tree.setChecked(subMenu.isHasMenu());
                    treeNodeHasSub.add(tree);
                }
                Tree parentTree = new Tree();
                parentTree.setpId("0");
                parentTree.setId(String.valueOf(menu.getMenuId()));
                parentTree.setName(menu.getMenuName());
                parentTree.setChecked(menu.isHasMenu());
                treeNodeHasSub.add(parentTree);
            } else {
                Tree parentTree = new Tree();
                parentTree.setpId("0");
                parentTree.setId(String.valueOf(menu.getMenuId()));
                parentTree.setName(menu.getMenuName());
                parentTree.setChecked(menu.isHasMenu());
                treeNode.add(parentTree);
            }
        }
        treeNodeHasSub.addAll(treeNode);
        return new Gson().toJson(treeNodeHasSub);
    }

    @Override
    public Menu findById(Integer menuId) {
        return menuDao.findById(menuId);
    }

    @Override
    public int save(Menu menu) {
        int order = this.findMaxOrder(Integer.parseInt(menu.getParentId()));
        menu.setMenuOrder(order+1);
        return menuDao.insert(menu);
    }

    @Override
    public int findMaxOrder(Integer parentId) {
        return menuDao.findMaxOrder(parentId);
    }


}
