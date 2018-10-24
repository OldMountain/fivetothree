package com.nxd.ftt.util.freemarker;

import com.nxd.ftt.common.freemarker.Freemarker;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.sql.SQLException;

/**
 * FreemarkerGenerator
 *
 * @author luhangqi
 * @date 2018/2/2
 */
public class FreemarkerGenerator {

    private static String propPath = "template/template.properties";


    public static void main(String[] args) {
        try {
            Freemarker.generator(propPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
