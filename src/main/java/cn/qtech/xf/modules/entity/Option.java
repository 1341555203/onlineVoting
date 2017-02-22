package cn.qtech.xf.modules.entity;

public class Option {
    private Integer id;

    private Integer menuId;

    private String optionTitle;

    private String delFlag;

    public Option(Integer id, Integer menuId, String optionTitle, String delFlag) {
        this.id = id;
        this.menuId = menuId;
        this.optionTitle = optionTitle;
        this.delFlag = delFlag;
    }

    public Option() {
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

    public String getOptionTitle() {
        return optionTitle;
    }

    public void setOptionTitle(String optionTitle) {
        this.optionTitle = optionTitle == null ? null : optionTitle.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}