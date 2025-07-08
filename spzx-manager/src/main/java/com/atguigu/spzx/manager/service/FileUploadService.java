package com.atguigu.spzx.manager.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Time: 2025/7/7
 * Author: Dankejun
 * Description:
 */
public interface FileUploadService {

    String upload(MultipartFile file);
}
