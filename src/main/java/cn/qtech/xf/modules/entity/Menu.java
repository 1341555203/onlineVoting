package cn.qtech.xf.modules.entity;

import java.util.Date;
import java.util.List;

public class Menu {
    private Integer id;

    private String menuTitle;

    private String menuDiscription;

    private String needPwd;

    private Date createDate;

    private Date cutoffTime;

    private String menuType;

    private String menuStatus;

    private String delFlag;

    private List<Option> options;

    private Integer createdBy;

    public Menu(Integer id, String menuTitle, String menuDiscription, String needPwd, Date createDate, Date cutoffTime, String menuType, String menuStatus, String delFlag,Integer createdBy) {
        this.id = id;
        this.menuTitle = menuTitle;
        this.menuDiscription = menuDiscription;
        this.needPwd = needPwd;
        this.createDate = createDate;
        this.cutoffTime = cutoffTime;
        this.menuType = menuType;
        this.menuStatus = menuStatus;
        this.delFlag = delFlag;
        this.createdBy=createdBy;
    }

    public Menu() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle == null ? null : menuTitle.trim();
    }

    public String getMenuDiscription() {
        return menuDiscription;
    }

    public void setMenuDiscription(String menuDiscription) {
        this.menuDiscription = menuDiscription == null ? null : menuDiscription.trim();
    }

    public String getNeedPwd() {
        return needPwd;
    }

    public void setNeedPwd(String needPwd) {
        this.needPwd = needPwd == null ? null : needPwd.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCutoffTime() {
        return cutoffTime;
    }

    public void setCutoffTime(Date cutoffTime) {
        this.cutoffTime = cutoffTime;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    public String getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(String menuStatus) {
        this.menuStatus = menuStatus == null ? null : menuStatus.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
}