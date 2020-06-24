package com.bgi.ms.engine.base.bean.email;

import java.util.List;

/**
 * @author
 * @date 20-3-12 16:53
 * @Description
 */
public class SmsParameter {
    private String apikey;   // api秘钥
    private String mobile;   // 电话号码
    private String template;  // 短信模板
    private List<String> text;   // 文本内容

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "SmsParameter{" +
                "apikey='" + apikey + '\'' +
                ", mobile='" + mobile + '\'' +
                ", template='" + template + '\'' +
                ", text=" + text +
                '}';
    }
}
