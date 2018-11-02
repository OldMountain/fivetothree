package com.nxd.ftt.controller.system;

import com.nxd.ftt.config.annotation.LogAndPermission;
import com.nxd.ftt.controller.base.BaseController;
import com.nxd.ftt.entity.Menu;
import com.nxd.ftt.entity.Page;
import com.nxd.ftt.entity.Role;
import com.nxd.ftt.entity.result.Response;
import com.nxd.ftt.entity.result.ResultKit;
import com.nxd.ftt.service.MenuService;
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
    
    @RequestMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("system/sys_menu/menu_list");
        Role role = new Role();
        role.setRoleId(SystemUtil.getCurrentUser().getRoleId());
        String treeNode = menuService.listTreeMenu(role, 0);
        mv.addObject("treeNode", treeNode);
        return mv;
    }

    @LogAndPermission(value = "/getMenuTree")
    @ResponseBody
    public Response getMenuTree(){
        Role role = new Role();
        role.setRoleId(SystemUtil.getCurrentUser().getRoleId());
        String treeNode = menuService.listTreeMenu(role, 0);
        return ResultKit.success(treeNode);
    }

    @LogAndPermission(value = "/toAdd")
    public ModelAndView toAdd(Integer menuId){
        ModelAndView mv = new ModelAndView("system/sys_menu/menu_add");
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
    public Response getSubMenu(String menuId, Page page){
        startPage(page);
        List<Menu> subMenuList = menuService.selectSubMenuByParentId(menuId);
        return ResultKit.table(subMenuList);
    }

    @LogAndPermission(value = "/save")
    @ResponseBody
    public Response save(Menu menu){
        menuService.save(menu);
        return ResultKit.success();
    }
}
