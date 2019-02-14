package com.dy.ssm.util;

import com.dy.ssm.model.FileCatagory;
import com.dy.ssm.model.FilePathConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author daiyun
 * @date 2018-6-6
 */
public class FileUtils {
    private static final Logger logger =  LoggerFactory.getLogger(FileUtils.class);


    /**
     * 初始化起始路径
     * @param realPath
     * @return
     */
    public static List<FileCatagory> initFileCatagory(String realPath) {

        logger.debug("初始化文件路径：" + realPath);
        File file = new File(realPath);
        if (!file.exists()){
            boolean sucess = file.mkdir();
            logger.debug("目录不存在，创建{}", sucess ? "成功" : "失败");
        }
        FileCatagory fileCatagory = ConvertUtils.convertFileCatagory(new File(realPath));

        List<FileCatagory> fileCatagories = new ArrayList<>();
        fileCatagories.add(fileCatagory);

        return fileCatagories;
    }

    /**
     * 获取相对路径
     * @param path
     * @return
     */
    public static String getRelativePath(String path){

        if (StringUtils.isEmpty(path)){
            return "";
        }

        return path.substring(path.indexOf(FilePathConstant.BASE_PATH));

    }

}
