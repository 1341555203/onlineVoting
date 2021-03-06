package cn.qtech.xf.modules.entity;

public class Attachment {
    private Integer id;

    private Integer ownerId;

    private String ownerType;

    private String attName;

    private String attOrigin;

    public Attachment(Integer id, Integer ownerId, String ownerType, String attName, String attOrigin) {
        this.id = id;
        this.ownerId = ownerId;
        this.ownerType = ownerType;
        this.attName = attName;
        this.attOrigin = attOrigin;
    }

    public Attachment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType == null ? null : ownerType.trim();
    }

    public String getAttName() {
        return attName;
    }

    public void setAttName(String attName) {
        this.attName = attName == null ? null : attName.trim();
    }

    public String getAttOrigin() {
        return attOrigin;
    }

    public void setAttOrigin(String attOrigin) {
        this.attOrigin = attOrigin == null ? null : attOrigin.trim();
    }
}