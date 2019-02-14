package com.dy.ssm.service;

import com.dy.ssm.model.FileCatagory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author daiyun
 * @date 2018-6-5
 */
public interface FtpService {


    /**
     * 根据文件路径获取其中的文件
     * @param path
     * @return
     */
    public List<FileCatagory> getFileCatagoryByPath(String path);

    /**
     * 删除文件
     * @param paths 文件路径
     * @return
     */
    public Integer delFiles(String[] paths);


    /**
     * 文件上传
     * @param files      上传的文件
     * @param realPath   上传路径
     */
    void upload(MultipartFile[] files, String realPath) throws IOException;

}
