package com.nxd.ftt.controller.api;

import com.nxd.ftt.common.util.DownloadUtil;
import com.nxd.ftt.util.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;

/**
 * DownloadController
 *
 * @author luhangqi
 * @date 2018/8/30
 */
@Controller
@RequestMapping("/api/download")
public class DownloadController {

    private Logger logger = LoggerFactory.getLogger(DownloadController.class);

    /**
     * 下载idea破解补丁
     *
     * @param response
     * @param version
     */
    @RequestMapping("/ideaCrack/{version:.+}")
    public void ideaCrack(HttpServletResponse response, @PathVariable(required = false, value = "version") String version) {
        String filepath = Const.FILE_ROOT_DIR + File.separator + "JetbrainsCrack";
        String fileName = "JetbrainsCrack-" + version + "-release-enc.jar";
        if (version == null || "".equals(version)) {
            File file = new File(filepath);
            if (file.exists()) {
                String[] files = file.list();
                Arrays.sort(files);
                fileName = files[files.length - 1];
            }
        }
        File file = new File(filepath, fileName);
        logger.info("filepath ->  " + file.getAbsolutePath());
        if (isExists(response, file)) {
            DownloadUtil.download(response, filepath, fileName);
        }

    }

    @RequestMapping("/browser/{version:.+}")
    public void jxBrowser(HttpServletResponse response, @PathVariable(value = "version") String version) {
        String filePath = Const.FILE_ROOT_DIR + File.separator + "JxBrowser";
        if (version == null || "".equals(version)) {
            version = "win32";
        }
        String fileName = "chromium-" + version + ".7z";
        File file = new File(filePath, fileName);
        logger.info("filepath ->  " + file.getAbsolutePath());
        if (isExists(response, file)) {
            DownloadUtil.download(response, filePath, fileName);
        }

    }

    @RequestMapping("/browserclient/{version:.+}")
    public void jxBrowserClient(HttpServletResponse response, @PathVariable(value = "version") String version) {
        String filePath = Const.FILE_ROOT_DIR + File.separator + "JxBrowser";
        if (version == null || "".equals(version)) {
            version = "win32";
        }
        String fileName = "chromium-" + version + ".7z";
        File file = new File(filePath, fileName);
        if (isExists(response, file)) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setContentLength(Integer.parseInt(String.valueOf(file.length())));
            try (

                    OutputStream out = response.getOutputStream();
                    InputStream in = new FileInputStream(file);
            ) {
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = in.read(bytes)) != -1) {
                    out.write(bytes, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public boolean isExists(HttpServletResponse response, File file) {
        if (!file.exists()) {
            try {
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().print("找不到文件");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }
}
