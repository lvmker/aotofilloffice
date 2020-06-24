package com.bgi.ms.engine.base.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bgi.ms.engine.base.bean.BaseResponse;
import com.bgi.ms.engine.base.exception.BaseException;

/**
 * ClassName: FileUtils 
 * @Description: 文件处理工具类
 * @author Cocoaer
 * @date 2019年6月19日
 */
public final class BaseFileUtils {

	private static Logger logger =  LoggerFactory.getLogger(BaseFileUtils.class);


	/**
	 * @Description: 文件上传
	 * @param @param file
	 * @param @param postUrl
	 * @param @return
	 * @return BaseResponse   
	 * @author Cocoaer
	 * @date 2019年6月19日
	 */
	public static BaseResponse uploadFile(MultipartFile file,String uploadUrl){
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(uploadUrl);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.addBinaryBody("file",file.getInputStream(), ContentType.MULTIPART_FORM_DATA, file.getOriginalFilename());
			// 文件流
		    builder.addTextBody("filename", file.getOriginalFilename());// 类似浏览器表单提交，对应input的name和value
		    HttpEntity entity = builder.build();
		    httpPost.setEntity(entity);
		    HttpResponse response = httpClient.execute(httpPost);// 执行提交
		    HttpEntity responseEntity = response.getEntity();
		    if (responseEntity != null) {
		        // 将响应内容转换为字符串
		        String result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
		        return new BaseResponse(result);
		    }else{
		    	return new BaseResponse(BaseException.ERROR_CODE.UNKNOWN,"文件上传响应超时!");
		    }
		} catch (Exception e) {
			return new BaseResponse(BaseException.ERROR_CODE.UNKNOWN,e.getMessage());
		}
	}
	
	/**
	 * @Description: 删除fastdfs文件公共接口
	 * @param @param interfaceURL
	 * @param @param paramURL
	 * @param @return
	 * @param @throws IOException
	 * @return Object   
	 * @author Cocoaer
	 * @date 2019年7月19日
	 */
	public static Object removeFastdfsFile(String interfaceURL,String paramURL){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("url", paramURL);
		try {
			return HttpClientUtil.post(interfaceURL, param);
		} catch (Exception e) {
			return new BaseResponse(BaseException.ERROR_CODE.UNKNOWN,"文件删除失败!");
		}
	}
	
	   public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
	        File targetFile = new File(filePath);
	        if (!targetFile.exists()) {
	            targetFile.mkdirs();
	        }
	        FileOutputStream out = new FileOutputStream(filePath + fileName);
	        out.write(file);
	        out.flush();
	        out.close();
	    }
	   public static byte[] toByteArray(InputStream input) throws IOException {
		   ByteArrayOutputStream output = new ByteArrayOutputStream();
		   byte[] buffer = new byte[1024*4];
		   int n = 0;
		   while (-1 != (n = input.read(buffer))) {
			   output.write(buffer, 0, n);
		   }
		   return output.toByteArray();
		   }
	    /**
	     * 功能描述: 读取指定文件的里面的内容
	     *
	     * @param fwqPath
	     * @return
	     * @auther WenJi Luo
	     * @date 2019/6/19 14:43
	     */
	    public static String readDefinition(String fwqPath) {
			String result = "";
			String encodeType=EncodeUtils.getEncode(fwqPath);
			BufferedReader reader = null;
			InputStream inputStream = null;
			try {
			URL myurl=new URL(fwqPath);//创建URL对象
			URLConnection uc=myurl.openConnection();
			// 判断的文件输入流
			inputStream = uc.getInputStream();
			reader = new BufferedReader(new InputStreamReader(uc.getInputStream(),encodeType));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				result = result + "\n" + tempString;
			}
			inputStream.close();
			reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e1) {
					}
				}
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e1) {
					}
				}
			}
			return result;
	    }
	    
		/**
		 * 创建文件
		 * @param destFileName
		 * @throws IOException
		 */
	    public static File createFile(String  destFileName) throws IOException {
			File file = new File(destFileName);
			if(file.exists()) {
				logger.info("创建单个文件" + destFileName + "失败，目标文件已存在！");
			}
			if (destFileName.endsWith(File.separator)) {
				logger.info("创建单个文件" + destFileName + "失败，目标文件不能为目录！");
			}
			//判断目标文件所在的目录是否存在
			if(!file.getParentFile().exists()) {
				//如果目标文件所在的目录不存在，则创建父目录
				logger.info("目标文件所在目录不存在，准备创建它！");
				if(!file.getParentFile().mkdirs()) {
					logger.info("创建目标文件所在目录失败！");
				}
			}
			//创建目标文件
			try {
				if (file.createNewFile()) {
					logger.info("创建单个文件" + destFileName + "成功！");
				} else {
					logger.info("创建单个文件" + destFileName + "失败！");
				}
			} catch (IOException e) {
				e.printStackTrace();
				logger.info("创建单个文件" + destFileName + "失败！" + e.getMessage());
			}
		return file;
		}


	/**
	 * 从网络Url中下载文件
	 * @param urlStr
	 * @param fileName
	 * @param savePath
	 * @throws IOException
	 */
	public static void downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException{
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		//设置超时间为3秒
		conn.setConnectTimeout(3*1000);
		//防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

		//得到输入流
		InputStream inputStream = conn.getInputStream();
		//获取自己数组
		byte[] getData = readInputStream(inputStream);

		//文件保存位置
		File saveDir = new File(savePath);
		if(!saveDir.exists()){
			saveDir.mkdirs();
		}
		File file = new File(saveDir+File.separator+fileName);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(getData);
		if(fos!=null){
			fos.close();
		}
		if(inputStream!=null){
			inputStream.close();
		}

		System.out.println("info:"+url+" download success");

	}

	

	/**
	 * 从输入流中获取字节数组
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static  byte[] readInputStream(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}
	
	
	public static File readBin2File(byte[] byteArray, String targetPath) {
		InputStream in = new ByteArrayInputStream(byteArray);
	    File file = new File(targetPath);
	    String path = targetPath.substring(0, targetPath.lastIndexOf("/"));
	    if (!file.exists()) {
	        new File(path).mkdir();
	    }
	    FileOutputStream fos = null;
	    try {
	        fos = new FileOutputStream(file);
	        int len = 0;
	        byte[] buf = new byte[1024];
	        while ((len = in.read(buf)) != -1) {
	            fos.write(buf, 0, len);
	        }
	        fos.flush();
	        return file;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (null != fos) {
	            try {
	                fos.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		return null;
	}

	public static boolean delFile(File file) {
        if (!file.exists()) {
            return false;
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                delFile(f);
            }
        }
        return file.delete();
    }
	
	public static File downloadFile(String urlPath, String filePath,String fileName) throws Exception {

	        logger.info("进入下载文件工具类");
	        File file = null;
	        BufferedInputStream bin = null;
	        OutputStream out = null;
	        try {
	            // 统一资源
	            URL url = new URL(urlPath);
	            // 连接类的父类，抽象类
	            URLConnection urlConnection = url.openConnection();
	            // http的连接类
	            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
	            // 设定请求的方法，默认是GET
	            httpURLConnection.setRequestMethod("GET");
	            // 设置字符编码
	            httpURLConnection.setRequestProperty("Charset", "UTF-8");
	            // 打开到此 URL 引用的资源的通信链接（如果尚未建立这样的连接）。
	            httpURLConnection.connect();
	            // 文件大小
	            int fileLength = httpURLConnection.getContentLength();
	            // 文件名
	            String filePathUrl = httpURLConnection.getURL().getFile();
	            String fileFullName = filePathUrl.substring(filePathUrl.lastIndexOf(File.separatorChar) + 1);
	            fileFullName = fileFullName.substring(fileFullName.lastIndexOf("/") + 1);
	            logger.info("开始下载文件：" + fileFullName);
	            String fileTyle=fileFullName.substring(fileFullName.lastIndexOf("."),fileFullName.length()); 
	            logger.info("file length---->" + fileLength);
	            url.openConnection();
	            bin = new BufferedInputStream(httpURLConnection.getInputStream());
	            String path = filePath+fileFullName;
	            if(!StringUtils.isEmpty(fileName)) {
	            	path = filePath+fileName+fileTyle;
	            }
	            logger.info("本地文件名称---->" + path);
	            file = new File(path);
	            if (!file.getParentFile().exists()) {
	                file.getParentFile().mkdirs();
	            }
	            out = new FileOutputStream(file);
	            int size = 0;
	            int len = 0;
	            byte[] buf = new byte[1024];
	            while ((size = bin.read(buf)) != -1) {
	                len += size;
	                out.write(buf, 0, size);
	                // 打印下载百分比
	                if ((len * 100 / fileLength)>50&&(len * 100 / fileLength)<55) {
	                    logger.info("下载了-------> " + len * 100 / fileLength + "%");
	                }else    if ((len * 100 / fileLength)>=98) {
	                    logger.info("下载了-------> " + len * 100 / fileLength + "%");
	                }
	                //logger.info("下载了-------> " + len * 100 / fileLength + "%");
	            }
	            return file;
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            throw new BaseException(e.toString()+"文件下载异常，请检查下载链接$$"+urlPath);
	        } finally {
	            if (bin!=null) {
	                bin.close();
	            }
	            if (out!=null) {
	                out.close();
	            }
	        }
	    }

	public static File zipFiles(String zipFileName,List<File> files) throws BaseException {
		try {
			File fileZip = new File(zipFileName);
	        if (!fileZip.getParentFile().exists()) {
	        	fileZip.getParentFile().mkdirs();
	        }
	    	FileOutputStream outStream = new FileOutputStream(fileZip);
	        ZipOutputStream toClient = new ZipOutputStream(outStream);
	        BaseFileUtils.zipFile(files,toClient);
	        toClient.close();
	        outStream.close();
	        return fileZip;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(BaseException.ERROR_CODE.UNKNOWN, "文件压缩失败");
		}

	}
	
	
    /**
    * 将服务器文件存到压缩包中
    */
    public static void zipFile(List<File> files, ZipOutputStream outputStream) throws IOException, ServletException {
        try {
            int size = files.size();
            Set<String> fileNameSet=new HashSet<>();
            // 压缩列表中的文件
            for (int i = 0; i < size; i++) {
                File file = (File) files.get(i);
                if(!fileNameSet.contains(file.getName())) {
                	fileNameSet.add(file.getName());
                	zipFile(file, outputStream);
                }
            }
        } catch (IOException e) {
            throw e;
        }
    }
    
    public static void zipFile(File inputFile, ZipOutputStream outputstream) throws IOException, ServletException {
        try {
            if (inputFile.exists()) {
                if (inputFile.isFile()) {
                    FileInputStream inStream = new FileInputStream(inputFile);
                    BufferedInputStream bInStream = new BufferedInputStream(inStream);
                    ZipEntry entry = new ZipEntry(inputFile.getName());
                    outputstream.putNextEntry(entry);

                    final int MAX_BYTE = 10 * 1024 * 1024; // 最大的流为10M
                    long streamTotal = 0; // 接受流的容量
                    int streamNum = 0; // 流需要分开的数量
                    int leaveByte = 0; // 文件剩下的字符数
                    byte[] inOutbyte; // byte数组接受文件的数据

                    streamTotal = bInStream.available(); // 通过available方法取得流的最大字符数
                    streamNum = (int) Math.floor(streamTotal / MAX_BYTE); // 取得流文件需要分开的数量
                    leaveByte = (int) streamTotal % MAX_BYTE; // 分开文件之后,剩余的数量

                    if (streamNum > 0) {
                        for (int j = 0; j < streamNum; ++j) {
                            inOutbyte = new byte[MAX_BYTE];
                            // 读入流,保存在byte数组
                            bInStream.read(inOutbyte, 0, MAX_BYTE);
                            outputstream.write(inOutbyte, 0, MAX_BYTE); // 写出流
                        }
                    }
                    // 写出剩下的流数据
                    inOutbyte = new byte[leaveByte];
                    bInStream.read(inOutbyte, 0, leaveByte);
                    outputstream.write(inOutbyte);
                    outputstream.closeEntry(); // Closes the current ZIP entry
                    // and positions the stream for
                    // writing the next entry
                    bInStream.close(); // 关闭
                    inStream.close();
                }
            } else {
                throw new ServletException("文件不存在！");
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public static void downloadFile(File file, HttpServletResponse response, boolean isDelete) {
        try {
            // 以流的形式下载文件。
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes("UTF-8"),"ISO-8859-1"));
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
            if(isDelete)
            {
                file.delete();        //是否将生成的服务器端文件删除
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
	
	public static void main(String[] args) throws IOException {
		InputStream inputStream = null;
		
		URL myurl=new URL("http://119.23.55.198/report/2019/12/06/141475/"+URLEncoder.encode("19B5200154-1-31_CL100138000_L02_谭琴_珠海市斗门区斗门镇中心卫生院_单胎报告_201912060734.pdf"));//创建URL对象
		URLConnection uc=myurl.openConnection();
		// 判断的文件输入流
		inputStream = uc.getInputStream();
		byte[] bytes=BaseFileUtils.readInputStream(inputStream);
		
		System.out.println(bytes.length);
		
//		System.out.println(BaseFileUtils.readDefinition("http://119.23.55.198/report/2019/12/06/141475/19B5200154-1-31_CL100138000_L02_谭琴_珠海市斗门区斗门镇中心卫生院_单胎报告_201912060734.pdf"));

		
//		System.out.println(BaseFileUtils.readDefinition("http://10.49.32.112/engine_fastdfs/group1/M00/00/3B/CjEgcF3x9uyAKSE1AAA9EKZ1V-s429.txt"));
	}
}
