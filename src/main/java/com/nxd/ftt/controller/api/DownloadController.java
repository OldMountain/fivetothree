package com.nxd.ftt.controller.api;

import com.nxd.ftt.common.util.DownloadUtil;
import com.nxd.ftt.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * DownloadController
 *
 * @author luhangqi
 * @date 2018/8/30
 */
@Controller
@RequestMapping("/download")
public class DownloadController {

    @RequestMapping("/ideaCrack")
    public void ideaCrack(HttpServletResponse response, String fileName) {
        DownloadUtil.download(response, Const.FILE_ROOT_DIR, fileName);

    }
}
