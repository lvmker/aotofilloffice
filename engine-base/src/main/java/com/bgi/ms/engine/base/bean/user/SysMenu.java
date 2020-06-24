package com.bgi.ms.engine.base.bean.user;



public class SysMenu {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 业务id
     */
    private String menuId;

    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单code
     */
    private String menuCode;

    /**
     * 菜单父节点
     */
    private String parentMenuId;

    /**
     * 记录最后修改者
     */
    private String lastModifiedUser;

    /**
     * 记录最后修改时间
     */
    private String lastModifiedTime;

    /**
     * 系统信息code
     */
    private String systemCode;

    /**
     * 菜单状态(禁用:0,启用:1)
     */
    private String menuStatus;

    /**
     * 模块code
     */
    private String moduleCode;

    /**
     * 上一级菜单
     */
    private String menuUpNode;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 菜单组id
     */
    private String menuGroupId;

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
     * @return menu_id - 业务id
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * 设置业务id
     *
     * @param menuId 业务id
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    /**
     * 获取菜单名称
     *
     * @return MENU_NAME - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }



    /**
     * 获取菜单父节点
     *
     * @return PARENT_MENU_ID - 菜单父节点
     */
    public String getParentMenuId() {
        return parentMenuId;
    }

    /**
     * 设置菜单父节点
     *
     * @param parentMenuId 菜单父节点
     */
    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId == null ? null : parentMenuId.trim();
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
     * 获取系统信息code
     *
     * @return SYSTEM_CODE - 系统信息code
     */
    public String getSystemCode() {
        return systemCode;
    }

    /**
     * 设置系统信息code
     *
     * @param systemCode 系统信息code
     */
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode == null ? null : systemCode.trim();
    }

    /**
     * 获取菜单状态(禁用:0,启用:1)
     *
     * @return menu_status - 菜单状态(禁用:0,启用:1)
     */
    public String getMenuStatus() {
        return menuStatus;
    }

    /**
     * 设置菜单状态(禁用:0,启用:1)
     *
     * @param menuStatus 菜单状态(禁用:0,启用:1)
     */
    public void setMenuStatus(String menuStatus) {
        this.menuStatus = menuStatus == null ? null : menuStatus.trim();
    }

    /**
     * 获取模块code
     *
     * @return module_code - 模块code
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * 设置模块code
     *
     * @param moduleCode 模块code
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode == null ? null : moduleCode.trim();
    }

    /**
     * 获取上一级菜单
     *
     * @return MENU_UP_NODE - 上一级菜单
     */
    public String getMenuUpNode() {
        return menuUpNode;
    }

    /**
     * 设置上一级菜单
     *
     * @param menuUpNode 上一级菜单
     */
    public void setMenuUpNode(String menuUpNode) {
        this.menuUpNode = menuUpNode == null ? null : menuUpNode.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMenuGroupId() {
        return menuGroupId;
    }

    public void setMenuGroupId(String menuGroupId) {
        this.menuGroupId = menuGroupId;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "id=" + id +
                ", menuId='" + menuId + '\'' +
                ", menuName='" + menuName + '\'' +
                ", parentMenuId='" + parentMenuId + '\'' +
                ", lastModifiedUser='" + lastModifiedUser + '\'' +
                ", lastModifiedTime=" + lastModifiedTime +
                ", systemCode='" + systemCode + '\'' +
                ", menuStatus='" + menuStatus + '\'' +
                ", moduleCode='" + moduleCode + '\'' +
                ", menuUpNode='" + menuUpNode + '\'' +
                ", menuGroupId='" + menuGroupId + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}