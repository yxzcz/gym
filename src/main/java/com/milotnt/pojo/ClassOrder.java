package com.milotnt.pojo;

/**
 * 实体类，代表一个课程的报名订单。
 */
public class ClassOrder {

    /**
     * 课程订单ID。
     */
    private Integer classOrderId;
    /**
     * 课程ID。
     */
    private Integer classId;
    /**
     * 课程名称。
     */
    private String className;
    /**
     * 教练名称。
     */
    private String coach;
    /**
     * 会员名称。
     */
    private String memberName;
    /**
     * 会员账号。
     */
    private Integer memberAccount;
    /**
     * 课程开始时间。
     */
    private String classBegin;

    /**
     * 无参构造函数。
     */
    public ClassOrder() {
    }

    /**
     * 有参构造函数，初始化课程订单信息。
     * @param classId 课程ID。
     * @param className 课程名称。
     * @param coach 教练名称。
     * @param memberName 会员名称。
     * @param memberAccount 会员账号。
     * @param classBegin 课程开始时间。
     */
    public ClassOrder(Integer classId, String className, String coach, String memberName, Integer memberAccount, String classBegin) {
        this.classId = classId;
        this.className = className;
        this.coach = coach;
        this.memberName = memberName;
        this.memberAccount = memberAccount;
        this.classBegin = classBegin;
    }

    /**
     * 获取课程订单ID。
     * @return 课程订单ID。
     */
    public Integer getClassOrderId() {
        return classOrderId;
    }

    /**
     * 设置课程订单ID。
     * @param classOrderId 课程订单ID。
     */
    public void setClassOrderId(Integer classOrderId) {
        this.classOrderId = classOrderId;
    }

    /**
     * 获取课程ID。
     * @return 课程ID。
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * 设置课程ID。
     * @param classId 课程ID。
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * 获取课程名称。
     * @return 课程名称。
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置课程名称。
     * @param className 课程名称。
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取教练名称。
     * @return 教练名称。
     */
    public String getCoach() {
        return coach;
    }

    /**
     * 设置教练名称。
     * @param coach 教练名称。
     */
    public void setCoach(String coach) {
        this.coach = coach;
    }

    /**
     * 获取会员名称。
     * @return 会员名称。
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 设置会员名称。
     * @param memberName 会员名称。
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * 获取会员账号。
     * @return 会员账号。
     */
    public Integer getMemberAccount() {
        return memberAccount;
    }

    /**
     * 设置会员账号。
     * @param memberAccount 会员账号。
     */
    public void setMemberAccount(Integer memberAccount) {
        this.memberAccount = memberAccount;
    }

    /**
     * 获取课程开始时间。
     * @return 课程开始时间。
     */
    public String getClassBegin() {
        return classBegin;
    }

    /**
     * 设置课程开始时间。
     * @param classBegin 课程开始时间。
     */
    public void setClassBegin(String classBegin) {
        this.classBegin = classBegin;
    }

    /**
     * 返回ClassOrder对象的字符串表示形式。
     * @return 包含课程订单详细信息的字符串。
     */
    @Override
    public String toString() {
        return "ClassOrder{" +
                "classOrderId=" + classOrderId +
                ", classId=" + classId +
                ", className='" + className + '\'' +
                ", coach='" + coach + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberAccount=" + memberAccount +
                ", classBegin='" + classBegin + '\'' +
                '}';
    }
}