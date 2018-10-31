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
 * 我的信息
 *
 * @author luhangqi
 * @date 2018/10/25
 */
@Controller
@RequestMapping("/personal")
public class BasicController {

    @Autowired
    private UserService userService;

    @LogAndPermission(value = "/basic")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("personal/basic");
        User user = SystemUtil.getCurrentUser();
        mv.addObject("user", user);
        return mv;
    }
}
