package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileServiceImpl implements IFileService{
    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public String upload(MultipartFile file, String path){
        //拿到文件名
        String filename = file.getOriginalFilename();
        //扩展名 aaa.jpg
        String fileExtensionName = filename.substring(filename.lastIndexOf(".") + 1);
        //上传文件名字
        String uploadFileName = UUID.randomUUID().toString()+ "." + fileExtensionName;
        logger.info("上传文件，上传文件名{}，上传路径{}，新文件名{}",filename,path,uploadFileName);

        //声明目录
        File fileDir = new File(path);
        if (!fileDir.exists()){
            //不存在，则创建
            fileDir.setWritable(true); //赋予权限，可写
            fileDir.mkdirs();
        }
        //创建文件
        File targetFile = new File(path, uploadFileName);
        try {
            file.transferTo(targetFile);
            //到这里，文件已经上传成功了

            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //已经上传到服务器上

            //todo 上传完毕之后，删除upload中的文件，因为文件在Tomcat中，会越来越大
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常", e);
            return targetFile.getName();
        }
        return null;
    }
}
