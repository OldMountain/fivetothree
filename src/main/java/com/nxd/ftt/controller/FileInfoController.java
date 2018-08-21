package com.nxd.ftt.controller;

import com.nxd.ftt.entity.FileInfo;
import com.nxd.ftt.entity.result.Response;
import com.nxd.ftt.entity.result.ResultKit;
import com.nxd.ftt.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

/**
 * FileInfoController
 *
 * @author OldMountain
 * @date 2018/06/12
 */
@Controller
@RequestMapping("/fileInfo")
public class FileInfoController {

    @Autowired
    private FileInfoService fileInfoService;


    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        List<FileInfo> fileInfoList = null;
        try {
            fileInfoList = fileInfoService.listAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mv.addObject("fileInfoList", fileInfoList);
        mv.setViewName("");
        return mv;
    }

    /**
     * 跳转到新增页面
     *
     * @return
     */
    @RequestMapping("/goAdd")
    public ModelAndView goAdd() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "save");
        mv.setViewName("");
        return mv;
    }

    /**
     * 跳转到编辑页面
     *
     * @return
     */
    @RequestMapping("/goEdit")
    public ModelAndView goEdit(String id) {
        ModelAndView mv = new ModelAndView();
        FileInfo fileInfo = null;
        try {
            fileInfo = fileInfoService.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mv.addObject("msg", "edit");
        mv.addObject("fileInfo", fileInfo);
        mv.setViewName("");
        return mv;
    }

    /**
     * 保存
     *
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public Response save(FileInfo fileInfo) {
        try {
            fileInfoService.save(fileInfo);
        } catch (SQLException e) {
            e.printStackTrace();
            ResultKit.error();
        }
        return ResultKit.success();
    }

    /**
     * 修改
     *
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Response edit(FileInfo fileInfo) {
        try {
            fileInfoService.modify(fileInfo);
        } catch (SQLException e) {
            e.printStackTrace();
            ResultKit.error();
        }
        return ResultKit.success();
    }

}
