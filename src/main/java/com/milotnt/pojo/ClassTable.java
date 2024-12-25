package com.milotnt.pojo;

/**
 * 实体类，代表一个课程的基本信息。
 */
public class ClassTable {

    /**
     * 课程ID。
     */
    private Integer classId;
    /**
     * 课程名称。
     */
    private String className;
    /**
     * 课程开始日期。
     */
    private String classBegin;
    /**
     * 课程时间。
     */
    private String classTime;
    /**
     * 教练名称。
     */
    private String coach;

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
     * 获取课程开始日期。
     * @return 课程开始日期。
     */
    public String getClassBegin() {
        return classBegin;
    }

    /**
     * 设置课程开始日期。
     * @param classBegin 课程开始日期。
     */
    public void setClassBegin(String classBegin) {
        this.classBegin = classBegin;
    }

    /**
     * 获取课程时间。
     * @return 课程时间。
     */
    public String getClassTime() {
        return classTime;
    }

    /**
     * 设置课程时间。
     * @param classTime 课程时间。
     */
    public void setClassTime(String classTime) {
        this.classTime = classTime;
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
     * 返回ClassTable对象的字符串表示形式。
     * @return 包含课程详细信息的字符串。
     */
    @Override
    public String toString() {
        return "ClassTable{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", classBegin='" + classBegin + '\'' +
                ", classTime='" + classTime + '\'' +
                ", coach='" + coach + '\'' +
                '}';
    }
}