package com.nxd.ftt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * LayoutController
 *
 * @author luhangqi
 * @date 2018/11/11
 */
@Controller
public class LayoutController {

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("view/layout");
        return mv;
    }

    @RequestMapping("/layout")
    public ModelAndView layout(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("view/layout");
        return mv;
    }
}
