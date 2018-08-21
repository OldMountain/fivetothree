package com.nxd.ftt.controller;

import com.nxd.ftt.common.entity.BaseFile;
import com.nxd.ftt.common.util.UploadUtil;
import com.nxd.ftt.entity.FileInfo;
import com.nxd.ftt.entity.result.Response;
import com.nxd.ftt.entity.result.ResultKit;
import com.nxd.ftt.service.FileInfoService;
import com.nxd.ftt.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * UploadController
 *
 * @author luhangqi
 * @date 2018/1/10
 */
@Controller
@RequestMapping("/file")
public class FileManagerController {

    @Autowired
    private FileInfoService fileInfoService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Response upload(HttpServletRequest request) {
        List<FileInfo> fileInfoList = new ArrayList<>();
        List<String> errorFileNameList = new ArrayList<>();
        try {
            List<BaseFile> pathList = UploadUtil.upload(request, Const.PICTURE_ROOT_DIR, "file");
            for (int i = 0; i < pathList.size(); i++) {
                BaseFile file = pathList.get(i);
                try {
                    FileInfo fileInfo = new FileInfo(file.getFileName(), (int) file.getFileSize(), file.getFilePath(), file.getEtx());
                    fileInfoService.save(fileInfo);
                    fileInfoList.add(fileInfo);
                } catch (SQLException e) {
                    e.printStackTrace();
                    errorFileNameList.add(file.getFileName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            ResultKit.error();
        }
        return ResultKit.success(fileInfoList);
    }

}
