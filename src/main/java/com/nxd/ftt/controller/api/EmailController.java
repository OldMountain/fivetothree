package com.nxd.ftt.controller.api;

import com.nxd.ftt.common.email.EmailUtil;
import com.nxd.ftt.common.entity.email.Email;
import com.nxd.ftt.common.entity.email.Image;
import com.nxd.ftt.common.exception.CommonException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * EmailController
 *
 * @author luhangqi
 * @date 2017/12/7
 */
@Controller
@RequestMapping(value = "/api/email")
public class EmailController {

    @RequestMapping(value = "/send", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String send(Email email, Image image) {
        try {
            EmailUtil.send(email, image, false);
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "fail";
        } catch (CommonException e) {
            return e.getMessage();
        }
        return "success";
    }

    @RequestMapping(value = "/sendAll", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String sendAll(Email email, Image image) {
        try {
            EmailUtil.send(email, image, true);
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "fail";
        } catch (CommonException e) {
            return e.getMessage();
        }
        return "success";
    }
}
