package com.bgi.ms.engine.base.bean.user;

import java.util.List;
import java.util.Map;

/**
 * @author : ChenHaiFeng
 * @date : 2019/6/26 10:42
 * @Description: Token
 */
public class Token {
    /**
     * userid
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 邮箱
     */
    private String userEmail;
    /**
     * 手机号码
     */
    private String userMobile;
    /**
     * 用户类型(0：UAMS管理员 1：华大员工 2：外包账号 3：外部用户)
     */
    private String userType;
    /**
     * 机构/代理
     */
    private String institution;
    /**
     * 密码类型
     */
    private String userPwdType;
    /**
     * 菜单集合
     */
    private List<SysMenu> uamsMenuList;

    private String token;
    /**
     * 数据组id
     */
    private String dataGroupId;
    /**
     * 数据权限
     */
    private Map<String,String> dataMap;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<SysMenu> getUamsMenuList() {
        return uamsMenuList;
    }

    public void setUamsMenuList(List<SysMenu> uamsMenuList) {
        this.uamsMenuList = uamsMenuList;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getUserPwdType() {
        return userPwdType;
    }

    public void setUserPwdType(String userPwdType) {
        this.userPwdType = userPwdType;
    }

    public String getDataGroupId() {
        return dataGroupId;
    }

    public void setDataGroupId(String dataGroupId) {
        this.dataGroupId = dataGroupId;
    }

    public Map<String, String> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, String> dataMap) {
        this.dataMap = dataMap;
    }

    @Override
    public String toString() {
        return "Token{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userType='" + userType + '\'' +
                ", institution='" + institution + '\'' +
                ", userPwdType='" + userPwdType + '\'' +
                ", uamsMenuList=" + uamsMenuList +
                ", token='" + token + '\'' +
                ", dataGroupId='" + dataGroupId + '\'' +
                '}';
    }
}
