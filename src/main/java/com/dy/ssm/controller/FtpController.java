package com.dy.ssm.controller;

import com.dy.ssm.model.FileCatagory;
import com.dy.ssm.model.FilePathConstant;
import com.dy.ssm.model.Folder;
import com.dy.ssm.service.FtpService;
import com.dy.ssm.util.ConvertUtils;
import com.dy.ssm.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author daiyun
 * @date 2018-6-5
 */
@Controller
@RequestMapping(value = "/ftp")
public class FtpController {

    private final Logger logger =  LoggerFactory.getLogger(FtpController.class);

    @Autowired
    private FtpService ftpService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String ftpIndex(){
        return "ftp/index";
    }

    /**
     * 获取下一层文件
     * @param model
     * @param path
     * @param level
     * @return
     */
    @RequestMapping(value = "/getNextFiles", method = RequestMethod.POST)
    public String getNextFiles(HttpServletRequest request, Model model,
                               @RequestParam(value = "path",required = false) String path,
                               @RequestParam(value = "level") Integer level){

        logger.debug("正在获取下一层文件，文件路径为：{}", path);
        List<FileCatagory> fileCatagories;
        if (StringUtils.isEmpty(path)){
            String realPath = request.getSession().getServletContext().getRealPath(FilePathConstant.BASE_PATH);
            fileCatagories = FileUtils.initFileCatagory(realPath);
        } else {
            fileCatagories = ftpService.getFileCatagoryByPath(path);
        }
        Folder folder = ConvertUtils.convertToFolder(fileCatagories, level, FileUtils.getRelativePath(path));
        model.addAttribute("folder", folder);
        return "ftp/file_show";
    }

    /**
     * 获取上一层文件
     * @param model
     * @param path
     * @return
     */
    @RequestMapping(value = "/getPreviousFiles", method = RequestMethod.POST)
    public String getPreviousFiles(HttpServletRequest request, Model model,
                                   @RequestParam(value = "path") String path,
                                   @RequestParam(value = "level") Integer level) {
        List<FileCatagory> fileCatagories = null;
        logger.debug("正在获取上一层文件，文件路径为：{}", path);
        String relativePath = null;
        try {
            //根目录层级为0
            if (level == 0){

                String realPath = request.getSession().getServletContext().getRealPath(FilePathConstant.BASE_PATH);
                fileCatagories = FileUtils.initFileCatagory(realPath);

            } else {
                relativePath = request.getSession().getServletContext().getRealPath(path);
                if (StringUtils.isEmpty(path)) {
                    FileCatagory fileCatagory = ConvertUtils.convertFileCatagory(null);
                    fileCatagories = new ArrayList<>();
                    fileCatagories.add(fileCatagory);
                } else {
                    File file = new File(relativePath);
                    File parentFile = file.getParentFile();
                    if (parentFile != null && parentFile.isDirectory()){
                        logger.debug(parentFile.getPath());
                        relativePath = FileUtils.getRelativePath(parentFile.getPath());
                        fileCatagories = ftpService.getFileCatagoryByPath(parentFile.getPath());
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        logger.debug("文件内容为：{}", fileCatagories);
        Folder folder = ConvertUtils.convertToFolder(fileCatagories, level, relativePath);
        model.addAttribute("folder", folder);
        return "ftp/file_show";
    }

    /**
     * 新建文件夹
     * @param request
     * @param model
     * @param globalRelativePath
     * @param level
     * @param folderName
     * @return
     */
    @RequestMapping(value = "/mkdir",method = RequestMethod.POST)
    public String createNewFolder(HttpServletRequest request,
                                  Model model,
                                  @RequestParam(value = "globalRelativePath") String globalRelativePath,
                                  @RequestParam(value = "level") Integer level,
                                  @RequestParam(value = "folderName") String folderName){

        List<FileCatagory> fileCatagories = null;
        String realPath = null;
        logger.debug("路径{}，新建文件夹：{}", globalRelativePath, folderName);
        if (StringUtils.isEmpty(globalRelativePath)){
            logger.debug("路径：{}为空", globalRelativePath);
            realPath = request.getSession().getServletContext().getRealPath(FilePathConstant.BASE_PATH);
            fileCatagories = FileUtils.initFileCatagory(realPath);
        } else {
            realPath = request.getSession().getServletContext().getRealPath(globalRelativePath);
            String newFolderRealPath = realPath + File.separator + folderName;
            File file = new File(newFolderRealPath);
            if (!file.exists()){
                boolean sucess = file.mkdir();
                logger.info("文件夹【{}】创建成功", folderName);
            }
            fileCatagories =  ftpService.getFileCatagoryByPath(realPath);
        }

        Folder folder = ConvertUtils.convertToFolder(fileCatagories, level, FileUtils.getRelativePath(realPath));
        model.addAttribute("folder", folder);

        return "ftp/file_show";

    }

    /**
     * 刷新文件夹
     * @param request
     * @param model
     * @param level
     * @return
     */
    @RequestMapping(value = "/refresh",method = RequestMethod.POST)
    public String refresh(HttpServletRequest request, Model model,
                          @RequestParam(value = "globalRelativePath") String globalRelativePath,
                          @RequestParam(value = "level") Integer level){

        logger.debug("正在刷新文件夹，路径：{}", globalRelativePath);
        List<FileCatagory> fileCatagories = null;
        String realPath = null;
        if (level == 0){
            realPath = request.getSession().getServletContext().getRealPath(FilePathConstant.BASE_PATH);
            fileCatagories = FileUtils.initFileCatagory(realPath);
        } else {
            if (!StringUtils.isEmpty(globalRelativePath)){
                realPath = request.getSession().getServletContext().getRealPath(globalRelativePath);
                fileCatagories =  ftpService.getFileCatagoryByPath(realPath);
            }
        }
        Folder folder = ConvertUtils.convertToFolder(fileCatagories, level, globalRelativePath);
        model.addAttribute("folder", folder);
        return "ftp/file_show";

    }

    /**
     * 删除文件
     * @param request
     * @param model
     * @param paths
     * @param globalRelativePath
     * @param level
     * @return
     */
    @RequestMapping(value = "/delFiles", method = RequestMethod.POST)
    public String delFiles(HttpServletRequest request, Model model,
                           @RequestParam(value = "paths[]") String[] paths,
                           @RequestParam(value = "globalRelativePath") String globalRelativePath,
                           @RequestParam(value = "level") Integer level){

        logger.debug("正在删除文件");
        if (paths == null || paths.length == 0){
            return "ftp/file_show";
        }

        Folder folder = null;
        int delFileNum = 0;
        try {

            delFileNum = ftpService.delFiles(paths);
            String realPath = request.getSession().getServletContext().getRealPath(globalRelativePath);
            List<FileCatagory> fileCatagories = ftpService.getFileCatagoryByPath(realPath);
            folder = ConvertUtils.convertToFolder(fileCatagories, level, globalRelativePath);

        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("delFileNum", delFileNum);
        model.addAttribute("folder", folder);
        return "ftp/file_show";
    }


    /**
     * 上传文件
     * @param request
     * @param redirectAttributes
     * @param files
     * @param globalRelativePath
     * @param level
     * @return
     */
    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         RedirectAttributes redirectAttributes,
                         @RequestParam(value = "files") MultipartFile[] files,
                         @RequestParam(value = "globalRelativePath") String globalRelativePath,
                         @RequestParam(value = "level") Integer level){

        logger.debug("正在上传文件");

        if (files == null ){
            throw new NullPointerException("upload - ths param files is null or empty");
        }

        try {

            String realPath = request.getSession().getServletContext().getRealPath(globalRelativePath);
            ftpService.upload(files, realPath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        redirectAttributes.addAttribute("globalRelativePath", globalRelativePath);
        redirectAttributes.addAttribute("level", level);
        return "forward:/ftp/refresh";

    }

}
