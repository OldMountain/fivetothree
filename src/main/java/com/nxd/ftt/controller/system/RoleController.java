package com.nxd.ftt.controller.system;

import com.nxd.ftt.config.annotation.LogAndPermission;
import com.nxd.ftt.controller.base.BaseController;
import com.nxd.ftt.entity.Page;
import com.nxd.ftt.entity.Role;
import com.nxd.ftt.entity.result.Response;
import com.nxd.ftt.entity.result.ResultKit;
import com.nxd.ftt.entity.result.ResultPage;
import com.nxd.ftt.service.MenuService;
import com.nxd.ftt.service.RolePermissionService;
import com.nxd.ftt.service.RoleService;
import com.nxd.ftt.util.Const;
import com.nxd.ftt.util.RightsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * RoleController
 *
 * @author luhangqi
 * @date 2017/12/5
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @RequestMapping(value = "/list")
    public ModelAndView listRoles(Role role) {
        ModelAndView mv = this.getModelAndView();
        if (role == null || role.getRoleId() == null) {
            role = (Role) getShiroSession().getAttribute(Const.SESSION_USERROL);
        }
        List<Role> roleModels = null;
        try {
            roleModels = roleService.getRoleListByParentId(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("roleList", roleModels);
        mv.setViewName("system/role/role_list");
        return mv;
    }

    @LogAndPermission(value = "/getData", permissions = "role.data")
    @ResponseBody
    public ResultPage getData(Page page) {
        startPage(page);
        List<Role> roles = roleService.listAll();
        return ResultPage.success(roles);
    }

    @RequestMapping(value = "/toAdd")
    public ModelAndView toAdd() {
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("system/role/role_add");
        return mv;
    }

    /**
     * 保存角色
     *
     * @param role
     * @return
     */
    @LogAndPermission(value = "/save", permissions = "role.add")
    @ResponseBody
    public Response save(Role role) {
        roleService.save(role);
        return ResultKit.success();
    }

    @LogAndPermission(value = "/toModify")
    public ModelAndView toModify(Integer roleId) {
        ModelAndView mv = this.getModelAndView("system/role/role_add");
        Role role = new Role();
        role.setRoleId(roleId);
        role = roleService.getRoleById(role);
        mv.addObject("role", role);
        return mv;
    }

    /**
     * 保存角色
     *
     * @param role
     * @return
     */
    @LogAndPermission(value = "/modify", permissions = "role.add")
    @ResponseBody
    public Response modify(Role role) {
        roleService.modify(role);
        return ResultKit.success();
    }

    @LogAndPermission(value = "/remove", permissions = "role.remove")
    @ResponseBody
    public Response remove(Integer roleId) {
        Role role = new Role();
        role.setRoleId(roleId);
        roleService.remove(role);
        return ResultKit.success();
    }

    /**
     * 保存权限
     *
     * @param roleId
     * @param permissions
     * @return
     */
    @LogAndPermission(value = "/saveRolePermission", permissions = "permission.save")
    @ResponseBody
    public Response savePermission(Integer roleId, String permissions, String menuIds) {
        rolePermissionService.save(roleId, permissions.split(","));
        Role role = new Role();
        role.setRoleId(roleId);
        role.setRights(String.valueOf(RightsHelper.sumRights(menuIds.split(","))));
        roleService.modify(role);
        return ResultKit.success();
    }
}
