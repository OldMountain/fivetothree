package com.nxd.ftt.util.listen;

import com.nxd.ftt.util.Const;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * WebApplicationContext
 *
 * @author luhangqi
 * @date 2018/6/4
 */
@Service
public class WebApplicationContext implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Const.WEB_APP_CONTEXT = applicationContext;
    }
}
