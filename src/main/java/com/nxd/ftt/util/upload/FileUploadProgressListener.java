package com.nxd.ftt.util.upload;

import com.nxd.ftt.entity.ProgressBean;
import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Created by entity on 2017/5/24.
 * 设置自己实现的文件上传进度监听器
 */
@Component
public class FileUploadProgressListener implements ProgressListener {

    private HttpSession session;

    /**
     * 实现ProgressListener接口的update方法
     *
     * @param bytesRead     已经上传到服务器的字节数
     * @param contentLength 表示所有文件的总大小
     * @param items         表示第几个文件
     */
    @Override
    public void update(long bytesRead, long contentLength, int items) {
        //设置上传进度
        ProgressBean progressBean = new ProgressBean(bytesRead, contentLength, items);
        //将上传进度保存到session中
        session.setAttribute("progress", progressBean);
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }
}
