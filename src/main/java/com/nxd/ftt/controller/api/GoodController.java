package com.nxd.ftt.controller.api;

import com.nxd.ftt.entity.Good;
import com.nxd.ftt.entity.result.Response;
import com.nxd.ftt.entity.result.ResultKit;
import com.nxd.ftt.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

/**
 * GoodController
 *
 * @author luhangqi
 * @date 2018/05/30
 */
@Controller
@RequestMapping("api/good")
public class GoodController {

    @Autowired
    private GoodService goodService;


    @RequestMapping("/list")
    @ResponseBody
    public Response list() {
        List<Good> goodList = null;
        try {
            goodList = goodService.listAll();
        } catch (SQLException e) {
            e.printStackTrace();
            ResultKit.error();
        }
        return ResultKit.success(goodList);
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
        mv.setViewName("test/good_edit");
        return mv;
    }

    /**
     * 跳转到编辑页面
     *
     * @return
     */
    @RequestMapping("/goEdit")
    public ModelAndView goEdit(Integer id) {
        ModelAndView mv = new ModelAndView();
        Good good = null;
        try {
            good = goodService.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mv.addObject("msg", "edit");
        mv.addObject("good", good);
        mv.setViewName("test/good_edit");
        return mv;
    }

    /**
     * 保存
     *
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    @Transactional
    public Response save(Good good) {
        try {
            goodService.save(good);
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
    public Response edit(Good good) {
        try {
            int i = goodService.modify(good);
            Good g = new Good();
            g.setTitle("测试");
            g.setPrice("60");
            goodService.save(g);
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
            ResultKit.error();
        }
        return ResultKit.success();
    }

}
