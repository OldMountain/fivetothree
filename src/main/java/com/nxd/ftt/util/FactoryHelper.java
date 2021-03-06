package com.nxd.ftt.util;

/**
 * FactoryHelper
 *
 * @author luhangqi
 * @date 2018/6/4
 */
public class FactoryHelper {

    public static Object getBean(String name) {
        return Const.WEB_APP_CONTEXT.getBean(name);
    }

    public static <T> T getBean(Class<T> c) {
        return Const.WEB_APP_CONTEXT.getBean(c);
    }
}
