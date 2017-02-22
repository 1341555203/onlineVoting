package cn.qtech.xf.modules.entity;

import java.util.Date;

public class Record {
    private Integer id;

    private Integer menuId;

    private Integer optionId;

    private Integer userId;

    private Date createDate;

    public Record(Integer id, Integer menuId, Integer optionId, Integer userId, Date createDate) {
        this.id = id;
        this.menuId = menuId;
        this.optionId = optionId;
        this.userId = userId;
        this.createDate = createDate;
    }

    public Record() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}