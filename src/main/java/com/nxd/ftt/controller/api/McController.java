package com.nxd.ftt.controller.api;

import com.nxd.ftt.controller.base.BaseController;
import com.nxd.ftt.entity.McServer;
import com.nxd.ftt.entity.Page;
import com.nxd.ftt.entity.result.Response;
import com.nxd.ftt.entity.result.ResultKit;
import com.nxd.ftt.service.McServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * ServerController
 *
 * @author luhangqi
 * @date 2018/6/21
 */
@Controller
@RequestMapping("api/mc")
public class McController extends BaseController {

    @Autowired
    private McServerService mcServerService;

    @RequestMapping("/getServerInfo")
    @ResponseBody
    public Response getServerInfo() {
        startPage(new Page(1, 1));
        List<McServer> list = mcServerService.listAll();
        McServer info = mcServerService.getInfo(list.get(0));
        return ResultKit.success(info);
    }
}
