package com.milotnt.pojo;

/**
 * 实体类，代表一个健身器材的基本信息。
 */
public class Equipment {

    /**
     * 器材ID。
     */
    private Integer equipmentId;
    /**
     * 器材名称。
     */
    private String equipmentName;
    /**
     * 器材位置。
     */
    private String equipmentLocation;
    /**
     * 器材状态。
     */
    private String equipmentStatus;
    /**
     * 器材备注信息。
     */
    private String equipmentMessage;

    /**
     * 无参构造函数。
     */
    public Equipment() {
    }

    /**
     * 有参构造函数，初始化器材信息。
     * @param equipmentId 器材ID。
     * @param equipmentName 器材名称。
     * @param equipmentLocation 器材位置。
     * @param equipmentStatus 器材状态。
     * @param equipmentMessage 器材备注信息。
     */
    public Equipment(Integer equipmentId, String equipmentName, String equipmentLocation, String equipmentStatus, String equipmentMessage) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.equipmentLocation = equipmentLocation;
        this.equipmentStatus = equipmentStatus;
        this.equipmentMessage = equipmentMessage;
    }

    /**
     * 获取器材ID。
     * @return 器材ID。
     */
    public Integer getEquipmentId() {
        return equipmentId;
    }

    /**
     * 设置器材ID。
     * @param equipmentId 器材ID。
     */
    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    /**
     * 获取器材名称。
     * @return 器材名称。
     */
    public String getEquipmentName() {
        return equipmentName;
    }

    /**
     * 设置器材名称。
     * @param equipmentName 器材名称。
     */
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    /**
     * 获取器材位置。
     * @return 器材位置。
     */
    public String getEquipmentLocation() {
        return equipmentLocation;
    }

    /**
     * 设置器材位置。
     * @param equipmentLocation 器材位置。
     */
    public void setEquipmentLocation(String equipmentLocation) {
        this.equipmentLocation = equipmentLocation;
    }

    /**
     * 获取器材状态。
     * @return 器材状态。
     */
    public String getEquipmentStatus() {
        return equipmentStatus;
    }

    /**
     * 设置器材状态。
     * @param equipmentStatus 器材状态。
     */
    public void setEquipmentStatus(String equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    /**
     * 获取器材备注信息。
     * @return 器材备注信息。
     */
    public String getEquipmentMessage() {
        return equipmentMessage;
    }

    /**
     * 设置器材备注信息。
     * @param equipmentMessage 器材备注信息。
     */
    public void setEquipmentMessage(String equipmentMessage) {
        this.equipmentMessage = equipmentMessage;
    }

    /**
     * 返回Equipment对象的字符串表示形式。
     * @return 包含器材详细信息的字符串。
     */
    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId=" + equipmentId +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentLocation='" + equipmentLocation + '\'' +
                ", equipmentStatus='" + equipmentStatus + '\'' +
                ", equipmentMessage='" + equipmentMessage + '\'' +
                '}';
    }
}