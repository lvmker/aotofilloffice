package com.bgi.engine.openoffice.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.bgi.ms.engine.base.bean.FileUploadVO;


@FeignClient(value = "engine-fastdfs", fallback=FastDFSServiceBack.class)
public interface FastDFSService {
	@RequestMapping(method = RequestMethod.POST, value ="/fdfsFile/uploadFile",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public FileUploadVO uploadFile(@RequestPart(value = "file", required = false) MultipartFile file);
}
