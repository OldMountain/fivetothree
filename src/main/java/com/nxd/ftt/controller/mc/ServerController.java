package com.nxd.ftt.controller.mc;

import com.nxd.ftt.entity.McServer;
import com.nxd.ftt.mchelper.entity.server.ServerInfo;
import com.nxd.ftt.mchelper.service.MCHelperService;
import com.nxd.ftt.mchelper.util.MCHelper;
import com.nxd.ftt.service.McServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * ServerController
 *
 * @author luhangqi
 * @date 2018/10/24
 */
@Controller
@RequestMapping("/mc/server")
public class ServerController {

    @Autowired
    private McServerService mcServerService;

    @RequestMapping(value = "/getInfo")
    public ModelAndView getInfo() {
        ModelAndView mv = new ModelAndView("mc/server_list");
        ServerInfo serverInfo = mcServerService.getInfo();
        mv.addObject("serverInfo", serverInfo);
        return mv;
    }

}
