package com.nxd.ftt.controller;

import com.nxd.ftt.common.entity.AddressCode;
import com.nxd.ftt.common.util.AddressUtil;
import com.nxd.ftt.entity.result.Response;
import com.nxd.ftt.entity.result.ResultKit;
import com.nxd.ftt.service.AddressCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 地址，区域划分代码
 *
 * @author luhangqi
 * @date 2018/10/28
 */
@Controller
@RequestMapping("/address")
public class AddressController {

    private static boolean isInit = true;

    @Autowired
    private AddressCodeService addressCodeService;

    @RequestMapping(value = "/initRegionCode")
    @ResponseBody
    public Response initRegionCode() {
        AddressUtil addressUtil = new AddressUtil() {
            @Override
            public void process(AddressCode addressCode) {
                addressCodeService.save(addressCode);
            }
        };
        List<AddressCode> list = addressUtil.getContent(AddressUtil.getURL(), 0, 5, "", 0);
        System.out.println(list.size());
        return ResultKit.success();
    }
}
