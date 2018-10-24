package com.nxd.ftt.controller.system;

import com.nxd.ftt.entity.About;
import com.nxd.ftt.entity.result.Response;
import com.nxd.ftt.entity.result.ResultKit;
import com.nxd.ftt.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Setting
 *
 * @author luhangqi
 * @date 2018/10/23
 */
@Controller
@RequestMapping("/system")
public class System {

    @Autowired
    private AboutService aboutService;

    @RequestMapping(value = "/about")
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("system/about");
        List<About> list = aboutService.listAll();
        if (list != null && list.size() > 0) {
            //返回第一条数据，通常情况只有一条数据
            mv.addObject("about",list.get(0));
        }
        mv.addObject("about",null);
        return mv;
    }


    @RequestMapping("/console")
    public String console() {
        return "view/console";
    }

    /**
     * 404页面
     *
     * @return
     */
    @RequestMapping("/notFound")
    public String notFound() {
        return "view/404";
    }

    /**
     * 错误页面
     *
     * @return
     */
    @RequestMapping("/error")
    public String error() {
        return "view/error";
    }
}
