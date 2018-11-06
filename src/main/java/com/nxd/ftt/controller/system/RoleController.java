package com.nxd.ftt.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.nxd.ftt.config.annotation.LogAndPermission;
import com.nxd.ftt.controller.base.BaseController;
import com.nxd.ftt.entity.Page;
import com.nxd.ftt.entity.Result;
import com.nxd.ftt.entity.Role;
import com.nxd.ftt.entity.result.ResultPage;
import com.nxd.ftt.service.MenuService;
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

    @RequestMapping(value = "/list")
    public ModelAndView listRoles(Role role) {
        ModelAndView mv = this.getModelAndView();
        if (role == null || role.getRoleId() == null) {
            role = (Role) getShiroSession().getAttribute(Const.SESSION_USERROL);
        }
        //查询登录者???
        if (role.getRoleId().equals("0")) {//系统管理员，拥有最高权限
//            List<Role> roleGroup = roleService.getRoleListByParentId(new Role("0"));
//            mv.addObject("group",roleGroup);
            List<Role> roleList = null;
            try {
                roleList = roleService.listAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mv.addObject("roleList", roleList);
        } else {
            List<Role> roleModels = null;
            try {
                roleModels = roleService.getRoleListByParentId(role);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mv.addObject("roleList", roleModels);
        }
        mv.setViewName("system/role/role_list");
        mv.addObject(Const.SESSION_QX, this.getHC());    //按钮权限
        return mv;
    }

    @LogAndPermission(value = "/getData",permissions = "role.data")
    @ResponseBody
    public ResultPage getData(Page page){
        startPage(page);
        List<Role> roles = roleService.listAll();
        return ResultPage.success(roles);
    }

    @RequestMapping(value = "/toAdd")
    public ModelAndView toAdd(Role role) {
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("system/role/role_add");
        mv.addObject("parentId", role.getParentId());
        mv.addObject("QX", this.getHC());
        return mv;
    }

    /**
     * 保存角色
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Result add(Role role) {
        Result result = new Result();
        try {
            roleService.save(role);
            result.setStatus("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 给角色分配菜单查看权限
     *
     * @return
     */
    @RequestMapping(value = "/auth")
    public ModelAndView authrize(Role role) {
        ModelAndView mv = this.getModelAndView();
        try {
            List<Role> roleModels = roleService.listAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String treeNode = null;
        try {
            treeNode = menuService.listTreeMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("treeNode", treeNode);
        mv.addObject("url", "role/saveQX");
        mv.addObject("params", "{\"roleId\":\"" + role.getRoleId() + "\"}");
        mv.addObject("roleId", role.getRoleId());
        mv.setViewName("menu_templete");
        return mv;
    }

    /**
     * 给角色分配按钮权限（增删改查:1、2、3、4）
     * @return
     */
    @RequestMapping(value = "/button")
    public ModelAndView button(Role role, int type){
        ModelAndView mv = this.getModelAndView();
        String treeNode = null;
        try {
            treeNode = menuService.listTreeMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("roleId",role.getRoleId());
        jsonObject.put("type",type);
        mv.addObject("treeNode",treeNode);
        mv.addObject("url","role/saveButton");
        mv.addObject("params",jsonObject.toJSONString());
        mv.setViewName("menu_templete");
        return mv;
    }


    /**
     * 修改角色姓名
     * @return
     */
    @RequestMapping(value = "/saveName")
    @ResponseBody
    public Result saveQX(Integer roleId, String roleName){
        Result resultModel = new Result();
        try {
            Role role = new Role();
            role.setRoleId(roleId);
            role.setRoleName(roleName);
            roleService.modify(role);
            resultModel.setStatus("success");
            resultModel.setCode(1);
            resultModel.setMessage("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultModel;
    }

    @RequestMapping(value = "remove")
    @ResponseBody
    public Result remove(Role role){
        Result result = new Result();
        roleService.remove(role);
        return result;
    }
}
