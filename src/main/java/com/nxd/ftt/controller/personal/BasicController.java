package com.nxd.ftt.controller.personal;

import com.nxd.ftt.config.annotation.LogAndPermission;
import com.nxd.ftt.entity.User;
import com.nxd.ftt.service.UserService;
import com.nxd.ftt.util.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 个人中心
 *
 * @author luhangqi
 * @date 2018/10/25
 */
@Controller
@RequestMapping(value = "/personal", name = "个人中心")
public class BasicController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户基础信息
     *
     * @return
     */
    @LogAndPermission(value = "/basic", name = "基础信息",permissions = "basic:add")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("personal/basic");
        User user = SystemUtil.getCurrentUser();
        mv.addObject("user", user);
        return mv;
    }
}
