package com.nxd.ftt.controller.api;

import com.nxd.ftt.entity.Client;
import com.nxd.ftt.entity.Result;
import com.nxd.ftt.entity.result.Response;
import com.nxd.ftt.entity.result.ResultKit;
import com.nxd.ftt.service.ClientService;
import com.nxd.ftt.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

/**
 * ClientController
 *
 * @author luhangqi
 * @date 2018/05/29
 */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @RequestMapping("/list")
    @ResponseBody
    public Response list() {
        List<Client> ClientList = null;
        try {
            ClientList = clientService.listAll();
        } catch (SQLException e) {
            e.printStackTrace();
            ResultKit.error();
        }
        return ResultKit.success(ClientList);
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
        mv.setViewName("test/client_edit");
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
        Client client = null;
        try {
            client = clientService.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mv.addObject("msg", "edit");
        mv.addObject("client", client);
        mv.setViewName("test/client_edit");
        return mv;
    }

    /**
     * 保存
     *
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public Result save(Client client) {
        Result result = new Result();
        try {
            clientService.save(client);
        } catch (SQLException e) {
            e.printStackTrace();
            result.setStatus(Const.FAIL);
        }
        return result;
    }

    /**
     * 修改
     *
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Result edit(Client client) {
        Result result = new Result();
        try {
            clientService.modify(client);
        } catch (SQLException e) {
            e.printStackTrace();
            result.setStatus(Const.FAIL);
        }
        return result;
    }

}
