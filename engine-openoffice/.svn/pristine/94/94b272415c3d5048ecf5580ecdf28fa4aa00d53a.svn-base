package com.bgi.engine.openoffice.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.artofsolving.jodconverter.BasicDocumentFormatRegistry;
import com.artofsolving.jodconverter.DocumentFormat;
import com.artofsolving.jodconverter.DocumentFormatRegistry;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;
import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import com.bgi.engine.openoffice.connectionpool.OpenofficeConnectionPool;
import com.bgi.engine.openoffice.utils.FileUtils;
import com.bgi.ms.engine.base.bean.BaseResponse;
import com.bgi.ms.engine.base.exception.BaseException;
import com.bgi.ms.engine.base.utils.BaseFileUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
@Service
public class OpenofficeService {
	private Logger logger=LoggerFactory.getLogger(OpenofficeService.class);
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	private String getCurrentTimestamp() {
        return sdf.format(new Date())+"-";
	}
	/**
	 * 创建文件
	 * @param file
	 * @throws IOException
	 */
	private void createFile(File file) throws IOException {
        if (file.exists()) {
        	file.delete();
        }
        file.createNewFile();
	}
	@Value("${temp.dir}")
	private String tempDir;
	@Value("${fastdfs.url}")
	private String fastfdsUrl;
	@Value("${libreoffice.home}")
	private String libreofficeHome;
//	@Autowired
//	private FastDFSService fastDFSService;
	
	@Value("${openoffice.host}")
	private String host;
	@Autowired
	private OpenofficeConnectionPool openofficeConnectionPool;
	private Gson defaultGson=new GsonBuilder().create();

	public String getExtensionName(String fileName) {
		String extensionName = fileName.substring(fileName.lastIndexOf(".")+1);
		return extensionName;
	}
	

	private Integer excuteCommand(String cmd) throws BaseException {
		logger.info("[执行系统命令]"+cmd);
        if(SystemUtils.IS_OS_LINUX){
        	logger.info("[执行系统命令]当前操作系统linux");
            try {
                // 使用Runtime来执行command，生成Process对象
                Process process = Runtime.getRuntime().exec(
                        new String[] { "/bin/sh", "-c", cmd });
                new ProcessStreamThread(process.getErrorStream(),"error").start();
                new ProcessStreamThread(process.getInputStream(),"").start();
                int exitCode = process.waitFor();
                logger.info("[执行系统命令]exitCode=="+exitCode);
                return exitCode;
//                // 取得命令结果的输出流
//                InputStream is = process.getInputStream();
//                // 用一个读输出流类去读
//                InputStreamReader isr = new InputStreamReader(is);
//                // 用缓冲器读行
//                BufferedReader br = new BufferedReader(isr);
//                String line = null;
//                StringBuilder sb = new StringBuilder();
//                while ((line = br.readLine()) != null) {
//                    sb.append(line);
//                }
//                is.close();
//                isr.close();
//                br.close();
//                logger.info("[执行系统命令]执行结果=="+sb.toString());
            } catch (java.lang.NullPointerException e) {
            	e.printStackTrace();
            } catch (java.io.IOException e) {
            	e.printStackTrace();
            } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else if(SystemUtils.IS_OS_WINDOWS){
        	logger.info("[执行系统命令]当前操作系统windows");
            Process process;
            try {
                //process = new ProcessBuilder(cmd).start();
                String[] param_array = cmd.split("[\\s]+");
                ProcessBuilder pb = new ProcessBuilder(param_array);
                process = pb.start();
                new ProcessStreamThread(process.getErrorStream(),"error").start();
                new ProcessStreamThread(process.getInputStream(),"").start();
                /*process=Runtime.getRuntime().exec(cmd);*/
                int exitCode = process.waitFor();
                logger.info("[执行系统命令]exitCode=="+exitCode);
                return exitCode;
//                InputStream is = process.getInputStream();
//                InputStreamReader isr = new InputStreamReader(is);
//                BufferedReader br = new BufferedReader(isr);
//                String line;
//                StringBuilder sb = new StringBuilder();
//  
//                while ((line = br.readLine()) != null) {
//                    sb.append(line);
//                }
//                is.close();
//                isr.close();
//                br.close();
//                logger.info("[执行系统命令]执行结果=="+sb.toString());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else {
        	throw new BaseException(BaseException.ERROR_CODE.PARAM_ILLEGAL,"不支持本操作系统");
        }
        
        return null;
    }

	/**
	 * 调用libreoffice转换文件（失败循环三次）
	 * @param url
	 * @param targetFileName
	 * @return
	 * @throws BaseException
	 */
	private File getTargetFile(String url,String targetFileName) throws BaseException {
		for(int i=0;i<3;i++) {
			String command = libreofficeHome+"soffice --headless --invisible --convert-to pdf "+url+" --outdir "+tempDir;
	        logger.info("[转换文件]执行命令=="+command);
	        Integer exitCode=excuteCommand(command);
            if(null==exitCode) {
            	throw new BaseException(BaseException.ERROR_CODE.UNSUPPORTED_METHOD,"执行系统命令出现异常"); 
            }
			File outputFile=new File(targetFileName);
			if(outputFile.exists()) {
				logger.info("[转换文件]"+targetFileName+"生成成功");
				return outputFile;
			}else {
				logger.info("[转换文件]"+targetFileName+"生成第"+(i+1)+"次失败");
			}
		}
		throw new BaseException(BaseException.ERROR_CODE.PARAM_INVALID,"文件转换失败，请检查待转换文件是否正常"); 
		
	}
	/**
	 * 调用aspose转换文件
	 * @param url
	 * @param targetFileName
	 * @return
	 * @throws BaseException
	 */
	private File getAsposeTargetFile(String url,String targetFileName) throws BaseException {
			try {
				File outputFile=new File(targetFileName);
				FileOutputStream os = new FileOutputStream(outputFile);
				Document document=new Document(url);
				document.save(os, SaveFormat.PDF); 
				return outputFile;
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new BaseException(BaseException.ERROR_CODE.PARAM_ILLEGAL, "文件地址错误");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new BaseException(BaseException.ERROR_CODE.PARAM_ILLEGAL, "读取文件出现异常");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new BaseException(BaseException.ERROR_CODE.PARAM_ILLEGAL, "系统异常");
			}
	}
	
	
	@SuppressWarnings("unchecked")
	public String coverAsposeFile(String url,String formatFileName) throws BaseException {
        try {
        	logger.info("[转换文件]url="+url+",formatFileName="+formatFileName);
        	String formatFileType=getExtensionName(formatFileName);
        	String sourceFileName = url.substring(url.lastIndexOf("/")+1);
        	String targetFileName=tempDir+sourceFileName.substring(0, sourceFileName.lastIndexOf("."))+"."+formatFileType;
        	logger.info("[转换文件]转换目标文件="+targetFileName);
            File outputFile=getAsposeTargetFile(url, targetFileName);
			try {
	            BaseResponse fileUploadResponse=BaseFileUtils.uploadFile(FileUtils.getMulFileByPath(outputFile), fastfdsUrl);
	            Map<String, Object> fileUploadResponseMap = defaultGson.fromJson((String) fileUploadResponse.getRows(),Map.class);
	            String previewurl=(String) fileUploadResponseMap.get("previewurl");
	            logger.info("[转换文件]返回前端地址==="+previewurl);
	            return previewurl;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new BaseException(BaseException.ERROR_CODE.UNSUPPORTED_METHOD,"临时文件创建出现异常"); 
			}finally {
				boolean successed=outputFile.delete();
				logger.info("[转换文件]删除本地文件=="+targetFileName+"结果"+successed);
				
			}
		} catch (BaseException e) {
			// TODO: handle exception
			throw e; 
		}
	}
	
	@SuppressWarnings("unchecked")
	public String coverFile(String url,String formatFileName) throws BaseException {
        try {
        	logger.info("[转换文件]url="+url+",formatFileName="+formatFileName);
        	String formatFileType=getExtensionName(formatFileName);
        	String sourceFileName = url.substring(url.lastIndexOf("/")+1);
        	String targetFileName=tempDir+sourceFileName.substring(0, sourceFileName.lastIndexOf("."))+"."+formatFileType;
        	logger.info("[转换文件]转换目标文件="+targetFileName);
            File outputFile=getTargetFile(url, targetFileName);
			try {
	            BaseResponse fileUploadResponse=BaseFileUtils.uploadFile(FileUtils.getMulFileByPath(outputFile), fastfdsUrl);
	            Map<String, Object> fileUploadResponseMap = defaultGson.fromJson((String) fileUploadResponse.getRows(),Map.class);
	            String previewurl=(String) fileUploadResponseMap.get("previewurl");
	            logger.info("[转换文件]返回前端地址==="+previewurl);
	            return previewurl;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new BaseException(BaseException.ERROR_CODE.UNSUPPORTED_METHOD,"临时文件创建出现异常"); 
			}finally {
				boolean successed=outputFile.delete();
				logger.info("[转换文件]删除本地文件=="+targetFileName+"结果"+successed);
				
			}
		} catch (BaseException e) {
			// TODO: handle exception
			throw e; 
		}
	}
 
	/**
	 * 文件转换
	 * @param fileUrl 文件路径  D:/temp/a.doc
	 * @param formatFileName 转换文件名
	 * @return
	 * @throws BaseException
	 */
	@SuppressWarnings("unchecked")
	public String coverFileBak(String fileUrl,String formatFileName) throws BaseException {
		try {
			logger.info("fileURL=="+fileUrl+",formatFileName=="+formatFileName);
//			File file = new File(fileUrl);
			URL url = new URL(fileUrl);
			InputStream fin = url.openStream();
//			FileInputStream fileInputStream = new FileInputStream(file);
			String fileName = url.getFile().substring(url.getFile().lastIndexOf("/")+1);
			logger.info("fileName=="+fileName);
			String tempFileName=getCurrentTimestamp()+fileName;
			formatFileName=UUID.randomUUID().toString()+formatFileName;
			logger.info("tempFileName=="+tempFileName+",tempFileName=="+tempFileName);
	        File outputFile = new File(tempDir + formatFileName);
	        File tempFile = new File(tempDir+ tempFileName);
	        createFile(outputFile);
	        createFile(tempFile);
            OutputStream os = new FileOutputStream(tempFile);
            int bytesRead = 0;
            byte[] buffer = new byte[1024 * 8];
            while ((bytesRead = fin.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fin.close();
			try {
				OpenOfficeConnection connection = openofficeConnectionPool.borrowObject();
//				OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
				logger.info("connection state:"+connection.isConnected());
				logger.info("pool state:"+openofficeConnectionPool.getPoolStateInfo());
				
				DocumentFormatRegistry factory = new BasicDocumentFormatRegistry();
				DocumentFormat inputDocumentFormat = factory
						.getFormatByFileExtension(getExtensionName(tempFile.getAbsolutePath()));
				DocumentFormat outputDocumentFormat = factory
						.getFormatByFileExtension(getExtensionName(outputFile.getAbsolutePath()));
//				StreamOpenOfficeDocumentConverter
				String localIp=getIpAddress();
				logger.info("host=="+host+",localIp=="+localIp);
				 
	            com.artofsolving.jodconverter.DocumentConverter converter = "localhost".equals(host)||"127.0.0.1".equals(host)||localIp.equals(host)?new OpenOfficeDocumentConverter(connection):new StreamOpenOfficeDocumentConverter(connection);
	            logger.info("start to cover file!!!");
	            converter.convert(tempFile,inputDocumentFormat, outputFile,outputDocumentFormat);
	            openofficeConnectionPool.returnObject(connection);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new BaseException(BaseException.ERROR_CODE.PARAM_NOEXISTS, "Openoffice转换文件出现异常"); 
			}finally {
				tempFile.delete();
			}
			logger.info("file covered finished");
            BaseResponse fileUploadResponse=BaseFileUtils.uploadFile(FileUtils.getMulFileByPath(outputFile), fastfdsUrl);
            Map<String, Object> fileUploadResponseMap = defaultGson.fromJson((String) fileUploadResponse.getRows(),Map.class);
            String previewurl=(String) fileUploadResponseMap.get("previewurl");
            logger.info("previewurl==="+previewurl);
            return previewurl;
		} catch (BaseException e) {
			throw e;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BaseException(BaseException.ERROR_CODE.PARAM_NOEXISTS, "文件"+fileUrl+"不存在");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BaseException(BaseException.ERROR_CODE.UNSUPPORTED_METHOD,"临时文件创建出现异常");
		}
	}
	
	public static String getIpAddress() {
	    try {
	      Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
	      InetAddress ip = null;
	      while (allNetInterfaces.hasMoreElements()) {
		NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
		if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
		  continue;
		} else {
		  Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
		  while (addresses.hasMoreElements()) {
		    ip = addresses.nextElement();
		    if (ip != null && ip instanceof Inet4Address) {
			return ip.getHostAddress();
		    }
		  }
		}
	      }
	    } catch (Exception e) {
		System.err.println("IP地址获取失败" + e.toString());
	    }
	    return "";
	}

	public class ProcessStreamThread extends Thread {  
	    InputStream is;  
	    String type;
	    public ProcessStreamThread(InputStream is,String type) {  
	        this.is = is;  
	        this.type=type;
	    }  
	    public void run() {  
	        try {  
	            InputStreamReader isr = new InputStreamReader(is);  
	            BufferedReader br = new BufferedReader(isr);  
	            String line = null;  
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                is.close();
                isr.close();
                br.close();
                logger.info("[命令执行"+type+"]"+sb.toString());
	        } catch (IOException ioe) {  
	            ioe.printStackTrace();  
	        }  
	    }  
	}  
	
	public static void main(String[] args) throws IOException, BaseException {
//		OpenofficeService openofficeService=new OpenofficeService();
//		openofficeService.cover2pdf("D:/temp/a.doc", "xy.pdf");
		OpenofficeService openofficeService=new OpenofficeService();
		System.out.println(openofficeService.getIpAddress());
	}
	
}
