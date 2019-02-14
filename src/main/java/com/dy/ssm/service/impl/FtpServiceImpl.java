package com.dy.ssm.service.impl;

import com.dy.ssm.model.FileCatagory;
import com.dy.ssm.service.FtpService;
import com.dy.ssm.util.ArrayUtils;
import com.dy.ssm.util.ConvertUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author daiyun
 * @date 2018-6-5
 */
@Service
public class FtpServiceImpl implements FtpService{
    private final Logger logger =  LoggerFactory.getLogger(FtpServiceImpl.class);

    @Override
    public List<FileCatagory> getFileCatagoryByPath(String path) {

        FileCatagory fileCatagory = new FileCatagory();
        List<FileCatagory> fileCatagories = new ArrayList<FileCatagory>();

        if (StringUtils.isEmpty(path)){
            fileCatagory.setMsg("路径为空");
        }

        File file = new File(path);
        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (files == null || files.length == 0){
                return Collections.emptyList();
            }

            for (File fileItem : files){
                fileCatagory = ConvertUtils.convertFileCatagory(fileItem);
                fileCatagories.add(fileCatagory);
            }

        }

        return fileCatagories;
    }

    @Override
    public Integer delFiles(String[] paths) {

        if (paths == null || paths.length == 0){
            throw new NullPointerException("delFiles - ths params paths is null or empty");
        }

        File file = null;
        boolean isDel = false;
        int delFileNum = 0;
        for (String path : paths){
            if (StringUtils.isEmpty(path)){
                continue;
            }
            file = new File(path);
            isDel = FileUtils.deleteQuietly(file);
            logger.debug("删除文件:{}", file.getName());
            if (isDel){
                delFileNum++;
            }
        }

        return delFileNum;
    }

    @Override
    public void upload(MultipartFile[] files, String realPath) throws IOException {

        if (files == null || files.length == 0) {
            throw new NullPointerException("upload - the param files is null or empty");
        }

        String fileName = null;
        String filePrefix = realPath + File.separator;
        File folder = new File(realPath);
        if (folder.isFile()) {
            throw new IllegalArgumentException("该路径不是文件夹");
        }

        File[] listFiles = folder.listFiles();
        List<String> fileNames = null;
        if (listFiles != null && listFiles.length > 0) {
            fileNames = new ArrayList<String>(listFiles.length);
            for (File file : listFiles) {
                fileNames.add(file.getName());
            }
        }

        for (MultipartFile multipartFile : files) {
            fileName = multipartFile.getOriginalFilename();
            if (!ArrayUtils.isEmpty(fileNames)) {
                if (fileNames.contains(fileName)) {
                    logger.warn("上传的文件名【{}】重复,取消上传", fileName);
                    continue;
                }
            }
            logger.debug("上传文件:{}", fileName);
            multipartFile.transferTo(new File(filePrefix, fileName));
        }


    }
}
