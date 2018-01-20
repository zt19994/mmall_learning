package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    /**
     * ftp文件上传
     * @param file
     * @param path
     * @return
     */
    String upload(MultipartFile file, String path);
}
