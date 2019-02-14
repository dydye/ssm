package com.dy.ssm.listener;


import com.dy.ssm.model.Progress;
import org.apache.commons.fileupload.ProgressListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * 文件上传监听器
 * @author daiyun
 * @date 2018-6-9
 */
@Component
public class FileUploadProgressListener implements ProgressListener {
    private final Logger logger =  LoggerFactory.getLogger(FileUploadProgressListener.class);
    private HttpSession session;

    public void setSession(HttpSession session) {
        this.session = session;
        //保存上传状态
        Progress status = new Progress();
        session.setAttribute("status", status);
    }

    @Override
    public void update(long pBytesRead, long pContentLength, int pItems) {
        Progress status = (Progress) session.getAttribute("status");
        status.setBytesRead(pBytesRead);
        status.setContentLength(pContentLength);
        status.setItems(pItems);
        logger.debug("FileUploadProgressListener - 上传状态:{}", status);
    }
}
