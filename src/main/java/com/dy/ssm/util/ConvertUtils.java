package com.dy.ssm.util;

import com.dy.ssm.model.FileCatagory;
import com.dy.ssm.model.Folder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.List;

/**
 * @author daiyun
 * @date 2018-6-5
 */
public class ConvertUtils {
    private static final Logger logger =  LoggerFactory.getLogger(ConvertUtils.class);

    public static FileCatagory convertFileCatagory(File file) {

        if(file == null){
            return new FileCatagory();
        }

        FileCatagory fileCatagory = new FileCatagory();
        fileCatagory.setFileId(IDGenerator.generateID());
        fileCatagory.setIsDirectory(file.isDirectory());
        fileCatagory.setFile(file);

        return fileCatagory;
    }


    public static Folder convertToFolder(List<FileCatagory> fileCatagories, Integer level, String relativePath) {

        if (StringUtils.isEmpty(level)){
            throw new NullPointerException("convertToFolder - the param level is null or empty");
        }

        Folder folder = new Folder();
        folder.setFileCatagories(fileCatagories);
        folder.setLevel(level);
        folder.setRelativePath(relativePath);

        return folder;

    }
}
