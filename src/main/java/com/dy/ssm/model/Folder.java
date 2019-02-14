package com.dy.ssm.model;

import java.util.List;

/**
 * @author daiyun
 * @date 2018-6-7
 */
public class Folder {

    /**
     * 文件夹中的文件
     */
    private List<FileCatagory> fileCatagories;

    /**
     * 文件层级
     */
    private Integer level;

    /**
     * 相对路径
     */
    private String relativePath;


    public List<FileCatagory> getFileCatagories() {
        return fileCatagories;
    }

    public void setFileCatagories(List<FileCatagory> fileCatagories) {
        this.fileCatagories = fileCatagories;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }
}
