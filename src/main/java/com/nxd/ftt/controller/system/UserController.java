package com.nxd.ftt.controller.system;


import com.nxd.ftt.controller.base.BaseController;
import com.nxd.ftt.entity.Result;
import com.nxd.ftt.entity.Role;
import com.nxd.ftt.entity.User;
import com.nxd.ftt.service.RoleService;
import com.nxd.ftt.service.UserService;
import com.nxd.ftt.util.PageData;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author OldMountain
 * @date 2017/12/4
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView mv = this.getModelAndView();
        List<PageData> userList = null;
        PageData pd = this.getPageData();
        try {
            userList = userService.getList(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("userList", userList);
        mv.setViewName("system/user/user_list");
        return mv;
    }

    /**
     * 去用户新增界面
     *
     * @return
     */
    @RequestMapping(value = "/toAdd")
    public ModelAndView toAdd() {
        ModelAndView mv = this.getModelAndView();
        List<Role> roleList = null;
        try {
            roleList = roleService.listAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("roleList", roleList);
        mv.addObject("msg", "save");
        mv.addObject("roleEdit", "1");//1:新增界面可以选择角色 0:新增界面不可以选择角色
        mv.addObject("QX", this.getHC());
        mv.setViewName("system/user/user_edit");
        return mv;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public boolean save(User user) {
        Result result = new Result();
        try {
            user.setUserId(this.get32UUID());
            user.setRights("");
            user.setPassword(new SimpleHash("SHA-1", user.getUserName(), user.getPassword()).toString());
            userService.save(user);
            return true;
        } catch (Exception e) {
            logBefore(logger, "异常" + e);
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/toEdit")
    public ModelAndView toEdit(User user) {
        ModelAndView mv = this.getModelAndView();
        try {
            user = userService.find(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("user", user);
        mv.addObject("msg", "edit");
        //1:新增界面可以选择角色 0:新增界面不可以选择角色
        mv.addObject("roleEdit", "0");
        mv.addObject("QX", this.getHC());
        mv.setViewName("system/user/user_edit");
        return mv;
    }

    /**
     * 保存修改
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public Result edit(User user) {
        Result resultModel = new Result();
        try {
            int i = userService.modify(user);
            if (i > 0) {
                resultModel.setStatus("success");
            }
        } catch (Exception e) {
            logBefore(logger, "异常" + e);
            e.printStackTrace();
        }
        return resultModel;
    }

    @RequestMapping(value = "/removeUser")
    @ResponseBody
    public Result removeUser(User user) {
        Result resultModel = new Result();
        try {
            userService.remove(user);
        } catch (Exception e) {
            logBefore(logger, "异常" + e);
            e.printStackTrace();
        }
        return resultModel;
    }

    @RequestMapping(value = "/batchRemoveUser")
    @ResponseBody
    public Result batchRemoveUser(String userIds) {
        Result resultModel = new Result();
        try {
            String[] ids = userIds.split(",");
            userService.batchRemove(ids);
        } catch (Exception e) {
            logBefore(logger, "异常" + e);
            e.printStackTrace();
        }
        return resultModel;
    }

    @RequestMapping(value = "/hasUserName")
    @ResponseBody
    public boolean hasUserName(User userModel) {
        String userId = userModel.getUserId();
        try {
            userModel = userService.find(userModel);
            if (userModel != null) {
                if (userId.equals(userModel.getUserId())) {
                    return true; //名字未被占用
                }
            } else {
                return true;
            }
        } catch (Exception e) {
            logBefore(logger, "异常" + e);
            e.printStackTrace();
        }
        return false;
    }

}
