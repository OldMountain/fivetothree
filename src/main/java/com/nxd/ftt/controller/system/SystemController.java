package com.nxd.ftt.controller.system;

import com.nxd.ftt.common.entity.AddressCode;
import com.nxd.ftt.common.util.AddressUtil;
import com.nxd.ftt.entity.About;
import com.nxd.ftt.mchelper.util.MCHelper;
import com.nxd.ftt.service.AboutService;
import com.nxd.ftt.service.McServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 系统参数
 *
 * @author luhangqi
 * @date 2018/10/23
 */
@Controller
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private AboutService aboutService;

    @Autowired
    private McServerService mcServerService;

    @RequestMapping(value = "/about")
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("system/about");
        About about = null;
        List<About> list = aboutService.listAll();
        if (list != null && list.size() > 0) {
            //返回第一条数据，通常情况只有一条数据
            about = list.get(0);
        }
        mv.addObject("about", about);
        return mv;
    }


    @RequestMapping("/console")
    public ModelAndView console() {
        ModelAndView mv = new ModelAndView("view/console");
        return mv;
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

    public static void main(String[] args) {
        AddressUtil addressUtil = new AddressUtil() {
            @Override
            public void process(AddressCode addressCode) {
                
            }
        };
        List<AddressCode> list = addressUtil.getContent(AddressUtil.getURL(), 0, 5, "", 0);
        System.out.println(list.size());
    }
}
