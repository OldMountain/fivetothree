package com.nxd.ftt.controller.system;

import com.nxd.ftt.config.annotation.LogAndPermission;
import com.nxd.ftt.controller.base.BaseController;
import com.nxd.ftt.entity.Menu;
import com.nxd.ftt.entity.Page;
import com.nxd.ftt.entity.Role;
import com.nxd.ftt.entity.Tree;
import com.nxd.ftt.entity.result.Response;
import com.nxd.ftt.entity.result.ResultKit;
import com.nxd.ftt.entity.result.ResultPage;
import com.nxd.ftt.entity.system.Permission;
import com.nxd.ftt.service.MenuService;
import com.nxd.ftt.service.PermissionService;
import com.nxd.ftt.util.Const;
import com.nxd.ftt.util.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * MenuController
 *
 * @author luhangqi
 * @date 2018/10/28
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("system/sys_menu/menu_list");
        Role role = new Role();
        role.setRoleId(SystemUtil.getCurrentUser().getRoleId());
        String treeNode = menuService.listTreeMenu();
        mv.addObject("treeNode", treeNode);
        return mv;
    }

    @LogAndPermission(value = "/getMenuTree")
    @ResponseBody
    public Response getMenuTree() {
        Role role = new Role();
        role.setRoleId(SystemUtil.getCurrentUser().getRoleId());
        String treeNode = menuService.listTreeMenu();
        return ResultKit.success(treeNode);
    }

    @LogAndPermission(value = "/toAdd")
    public ModelAndView toAdd(Integer menuId, Integer level) {
        ModelAndView mv = new ModelAndView();
        if (level != null && level == 2) {
            mv.setViewName("system/sys_menu/permission_add");
        } else {
            mv.setViewName("system/sys_menu/menu_add");
        }
        Menu menu = menuService.findById(menuId);
        if (menu == null) {
            menu = new Menu();
            menu.setMenuId(0);
            menu.setMenuName(Const.ROOT_MENU_NAME);
        }
        mv.addObject("menu", menu);
        return mv;
    }

    @LogAndPermission(value = "/getSubMenu")
    @ResponseBody
    public ResultPage getSubMenu(String menuId, Page page) {
        startPage(page);
        List<Menu> subMenuList = menuService.selectSubMenuByParentId(menuId);
        return ResultPage.success(subMenuList);
    }

    @LogAndPermission(value = "/save", permissions = "menu.save")
    @ResponseBody
    public Response save(Menu menu) {
        menuService.save(menu);
        return ResultKit.success();
    }

    @LogAndPermission(value = "/modify", permissions = "menu.modify")
    @ResponseBody
    public Response modify(Menu menu) {
        menuService.modify(menu);
        return ResultKit.success();
    }

    @LogAndPermission(value = "/reset", permissions = "menu.reset")
    @ResponseBody
    public Response reset() {
        menuService.resetCurrentMenu();
        return ResultKit.success();
    }

    @LogAndPermission(value = "/getPermissionsTree")
    @ResponseBody
    public Response getPermissionsTree(Integer roleId,String userId) {
        List<Tree> permissions;
        if (userId != null && !"".equals(userId)) {
            permissions = permissionService.getPermissionTree(roleId);
        }else {
            permissions = permissionService.getPermissionTree(roleId);
        }
        return ResultKit.success(permissions);
    }

    @LogAndPermission(value = "/getPermissions")
    @ResponseBody
    public ResultPage getPermissions(String menuId, Page page) {
        startPage(page);
        Permission permission = new Permission();
        permission.setMenuId(Integer.parseInt(menuId));
        List<Permission> permissions = permissionService.list(permission);
        return ResultPage.success(permissions);
    }

    @LogAndPermission(value = "/savePermission", permissions = "permission.save")
    @ResponseBody
    public Response savePermission(Permission permission) {
        permissionService.save(permission);
        return ResultKit.success();
    }

    @LogAndPermission(value = "/modifyPermission", permissions = "permission.modify")
    @ResponseBody
    public Response modifyPermission(Permission permission) {
        permissionService.modify(permission);
        return ResultKit.success();
    }
}
