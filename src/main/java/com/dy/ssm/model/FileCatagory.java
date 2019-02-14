package com.dy.ssm.model;

import java.io.File;

/**
 * @author daiyun
 * @date 2018-6-5
 */
public class FileCatagory{

    /**
     * 文件Id
     */
    private String fileId;

    /**
     * 文件
     */
    private File file;

    /**
     * 是否是文件夹
     */
    private Boolean isDirectory;

    /**
     * 提示语
     */
    private String msg;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Boolean getIsDirectory() {
        return isDirectory;
    }

    public void setIsDirectory(Boolean directory) {
        isDirectory = directory;
    }

    @Override
    public String toString() {
        return "FileCatagory{" +
                "file=" + file +
                ", isDirectory=" + isDirectory +
                '}';
    }
}
