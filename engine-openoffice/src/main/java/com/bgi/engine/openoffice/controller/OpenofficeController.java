package com.bgi.engine.openoffice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bgi.engine.openoffice.service.OpenofficeService;
import com.bgi.ms.engine.base.bean.BaseResponse;
import com.bgi.ms.engine.base.bean.OpenofficeRequestParamer;
import com.bgi.ms.engine.base.exception.BaseException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

@RestController
public class OpenofficeController {


	private Logger logger=LoggerFactory.getLogger(OpenofficeController.class);
	private Gson defaultGson=new GsonBuilder().create();
	private JsonParser defaultJsonParser=new JsonParser();
	@Autowired
	private OpenofficeService openofficeService;
	@RequestMapping("/covertFile")
	public BaseResponse covertFile(@RequestBody String fileInfo) {
		logger.info("[转换文件]入参"+fileInfo);
		JsonElement responseElement = defaultJsonParser.parse(fileInfo);
		OpenofficeRequestParamer requestParamer=defaultGson.fromJson(responseElement, new TypeToken<OpenofficeRequestParamer>() { }.getType());
		try {
//			String filePath=openofficeService.coverFile(requestParamer.getFileName(), requestParamer.getFormatFileName());
			String filePath=openofficeService.coverAsposeFile(requestParamer.getFileName(), requestParamer.getFormatFileName());
			BaseResponse baseResponse=new BaseResponse(filePath);
			return baseResponse;
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new BaseResponse(e.getCode(), e.getMessage());
		}
		
	}
	
	@RequestMapping("/covertLibreOfficeFile")
	public BaseResponse covertLibreOfficeFile(@RequestBody String fileInfo) {
		logger.info("[转换文件]入参"+fileInfo);
		JsonElement responseElement = defaultJsonParser.parse(fileInfo);
		OpenofficeRequestParamer requestParamer=defaultGson.fromJson(responseElement, new TypeToken<OpenofficeRequestParamer>() { }.getType());
		try {
			String filePath=openofficeService.coverFile(requestParamer.getFileName(), requestParamer.getFormatFileName());
			BaseResponse baseResponse=new BaseResponse(filePath);
			return baseResponse;
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new BaseResponse(e.getCode(), e.getMessage());
		}
		
	}
	
	
	

}
