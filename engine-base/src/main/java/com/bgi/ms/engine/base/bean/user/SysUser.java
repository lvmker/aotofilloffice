package com.bgi.ms.engine.base.bean.user;

import java.util.List;
public class SysUser {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 业务id
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userMd5Pwd;

    /**
     * 密码类型(0:默认密码 1:已修改密码)
     */
    private String userPwdType;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号码
     */
    private String userMobile;

    /**
     * 性别(未知:0;女:1;男：2)
     */
    private String userGender;

    /**
     * 用户类型(0：UAMS管理员 1：华大员工 2：外包账号 3：外部用户)
     */
    private String userType;

    /**
     * 电子邮箱
     */
    private String userEmail;

    /**
     * 联系地址
     */
    private String userAddress;

    /**
     * 员工状态(离职0;在职:1)
     */
    private String userState;

    /**
     * 账号状态(禁用:0,启用:1)
     */
    private String accountCount;

    /**
     * 记录最后修改者
     */
    private String lastModifiedUser;

    /**
     * 记录最后修改时间
     */
    private String lastModifiedTime;

    /**
     * 用户最后登入时间
     */
    private String lastLoginTime;
    /**
     * 菜单集合
     */
    private List<SysMenu> uamsMenuList;

    /**
     * 年龄
     */
    private String userAge;

    /**
     * 所属机构
     */
    private String institution;
    /**
     * 数据组id
     */
    private String dataGroupId;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取业务id
     *
     * @return User_id - 业务id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置业务id
     *
     * @param userId 业务id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取用户名
     *
     * @return User_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取密码
     *
     * @return user_md5_pwd - 密码
     */
    public String getUserMd5Pwd() {
        return userMd5Pwd;
    }

    /**
     * 设置密码
     *
     * @param userMd5Pwd 密码
     */
    public void setUserMd5Pwd(String userMd5Pwd) {
        this.userMd5Pwd = userMd5Pwd == null ? null : userMd5Pwd.trim();
    }

    /**
     * 获取真实姓名
     *
     * @return REAL_NAME - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取手机号码
     *
     * @return USER_MOBILE - 手机号码
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * 设置手机号码
     *
     * @param userMobile 手机号码
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    /**
     * 获取性别(未知:0;女:1;男：2)
     *
     * @return USER_GENDER - 性别(未知:0;女:1;男：2)
     */
    public String getUserGender() {
        return userGender;
    }

    /**
     * 设置性别(未知:0;女:1;男：2)
     *
     * @param userGender 性别(未知:0;女:1;男：2)
     */
    public void setUserGender(String userGender) {
        this.userGender = userGender == null ? null : userGender.trim();
    }

    /**
     * 获取用户类型(0：UAMS管理员 1：华大员工 2：外包账号 3：外部用户)
     *
     * @return USER_TYPE - 用户类型(0：UAMS管理员 1：华大员工 2：外包账号 3：外部用户)
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置用户类型(0：UAMS管理员 1：华大员工 2：外包账号 3：外部用户)
     *
     * @param userType 用户类型(0：UAMS管理员 1：华大员工 2：外包账号 3：外部用户)
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 获取电子邮箱
     *
     * @return USER_EMAIL - 电子邮箱
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 设置电子邮箱
     *
     * @param userEmail 电子邮箱
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * 获取联系地址
     *
     * @return USER_ADDRESS - 联系地址
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * 设置联系地址
     *
     * @param userAddress 联系地址
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    /**
     * 获取员工状态(离职0;在职:1)
     *
     * @return USER_STATE - 员工状态(离职0;在职:1)
     */
    public String getUserState() {
        return userState;
    }

    /**
     * 设置员工状态(离职0;在职:1)
     *
     * @param userState 员工状态(离职0;在职:1)
     */
    public void setUserState(String userState) {
        this.userState = userState == null ? null : userState.trim();
    }

    /**
     * 获取账号状态(禁用:0,启用:1)
     *
     * @return account_count - 账号状态(禁用:0,启用:1)
     */
    public String getAccountCount() {
        return accountCount;
    }

    /**
     * 设置账号状态(禁用:0,启用:1)
     *
     * @param accountCount 账号状态(禁用:0,启用:1)
     */
    public void setAccountCount(String accountCount) {
        this.accountCount = accountCount == null ? null : accountCount.trim();
    }

    /**
     * 获取记录最后修改者
     *
     * @return LAST_MODIFIED_USER - 记录最后修改者
     */
    public String getLastModifiedUser() {
        return lastModifiedUser;
    }

    /**
     * 设置记录最后修改者
     *
     * @param lastModifiedUser 记录最后修改者
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser == null ? null : lastModifiedUser.trim();
    }

    /**
     * 获取记录最后修改时间
     *
     * @return LAST_MODIFIED_TIME - 记录最后修改时间
     */
    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * 设置记录最后修改时间
     *
     * @param lastModifiedTime 记录最后修改时间
     */
    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * 获取用户最后登入时间
     *
     * @return LAST_LOGIN_TIME - 用户最后登入时间
     */
    public String getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置用户最后登入时间
     *
     * @param lastLoginTime 用户最后登入时间
     */
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public List<SysMenu> getUamsMenuList() {
        return uamsMenuList;
    }

    public void setUamsMenuList(List<SysMenu> uamsMenuList) {
        this.uamsMenuList = uamsMenuList;
    }

    /**
     * 获取年龄
     *
     * @return USER_AGE - 年龄
     */
    public String getUserAge() {
        return userAge;
    }

    /**
     * 设置年龄
     *
     * @param userAge 年龄
     */
    public void setUserAge(String userAge) {
        this.userAge = userAge == null ? null : userAge.trim();
    }

    /**
     * 获取所属机构
     *
     * @return institution - 所属机构
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * 设置所属机构
     *
     * @param institution 所属机构
     */
    public void setInstitution(String institution) {
        this.institution = institution == null ? null : institution.trim();
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

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userMd5Pwd='" + userMd5Pwd + '\'' +
                ", userPwdType='" + userPwdType + '\'' +
                ", realName='" + realName + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userType='" + userType + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userState='" + userState + '\'' +
                ", accountCount='" + accountCount + '\'' +
                ", lastModifiedUser='" + lastModifiedUser + '\'' +
                ", lastModifiedTime='" + lastModifiedTime + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", uamsMenuList=" + uamsMenuList +
                ", dataGroupId=" + dataGroupId +
                ", userAge='" + userAge + '\'' +
                ", institution='" + institution + '\'' +
                '}';
    }
}