package com.nxd.ftt.controller.api;

import com.nxd.ftt.entity.result.Response;
import com.nxd.ftt.entity.result.ResultKit;
import com.nxd.ftt.mchelper.entity.server.ServerInfo;
import com.nxd.ftt.mchelper.util.MCHelper;
import com.nxd.ftt.service.McServerService;
import com.nxd.ftt.util.Const;
import com.nxd.ftt.util.ServerCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ServerController
 *
 * @author luhangqi
 * @date 2018/6/21
 */
@Controller
@RequestMapping("api/mc")
public class McController {

    @Autowired
    private McServerService mcServerService;

    @RequestMapping("/getServerInfo")
    @ResponseBody
    public Response getServerInfo() {
        return ResultKit.success(mcServerService.getInfo());
    }
}
