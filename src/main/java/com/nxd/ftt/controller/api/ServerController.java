package com.nxd.ftt.controller.api;

import com.nxd.ftt.entity.result.Response;
import com.nxd.ftt.entity.result.ResultKit;
import com.nxd.ftt.mchelper.entity.server.ServerInfo;
import com.nxd.ftt.mchelper.util.MCHelper;
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
@RequestMapping("server")
public class ServerController {

    @Autowired
    private ServerCacheUtil serverCacheUtil;

    @RequestMapping("/getServerInfo")
    @ResponseBody
    public Response getServerInfo() {
        ServerInfo serverInfo = null;
        try {
            Object data = serverCacheUtil.getData(Const.SERVER_INFO_CACHE);
            if (data != null) {
                serverInfo = ((ServerInfo) data);
            } else {
                serverInfo = MCHelper.getServerInfo();
                serverCacheUtil.putCache(Const.SERVER_INFO_CACHE, serverInfo, 1000 * 60);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResultKit.error();
        }
        return ResultKit.success(serverInfo);
    }
}
