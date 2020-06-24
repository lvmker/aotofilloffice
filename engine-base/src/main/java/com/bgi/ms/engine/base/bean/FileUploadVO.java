package com.bgi.ms.engine.base.bean;

/**
 * ClassName: FileUploadVO 
 * @Description: 文件上传视图
 * @author Cocoaer
 * @date 2018年12月20日
 */
public class FileUploadVO {

    private String id;
    
    private String name;
    
    private String size;
    
    private String formatSize;
    
    private String type;
    
    private String createdate;
    
    private String downloadurl;
    
    private String previewurl;
    
    private String status;
    
    private String msg;
    
    private int httpStatusCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getDownloadurl() {
        return downloadurl;
    }

    public void setDownloadurl(String downloadurl) {
        this.downloadurl = downloadurl;
    }

    public String getPreviewurl() {
        return previewurl;
    }

    public void setPreviewurl(String previewurl) {
        this.previewurl = previewurl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

	public String getFormatSize() {
		return formatSize;
	}

	public void setFormatSize(String formatSize) {
		this.formatSize = formatSize;
	}
}
