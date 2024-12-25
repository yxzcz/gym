package com.milotnt.pojo;

/**
 * 实体类，代表一个员工的基本信息。
 */
public class Employee {

    /**
     * 员工账号。
     */
    private Integer employeeAccount;
    /**
     * 员工姓名。
     */
    private String employeeName;
    /**
     * 员工性别。
     */
    private String employeeGender;
    /**
     * 员工年龄。
     */
    private Integer employeeAge;
    /**
     * 入职时间。
     */
    private String entryTime;
    /**
     * 职位。
     */
    private String staff;
    /**
     * 员工备注信息。
     */
    private String employeeMessage;

    /**
     * 无参构造函数。
     */
    public Employee() {
    }

    /**
     * 有参构造函数，初始化员工信息。
     * @param employeeAccount 员工账号。
     * @param employeeName 员工姓名。
     * @param employeeGender 员工性别。
     * @param employeeAge 员工年龄。
     * @param entryTime 入职时间。
     * @param staff 职位。
     * @param employeeMessage 员工备注信息。
     */
    public Employee(Integer employeeAccount, String employeeName, String employeeGender, Integer employeeAge, String entryTime, String staff, String employeeMessage) {
        this.employeeAccount = employeeAccount;
        this.employeeName = employeeName;
        this.employeeGender = employeeGender;
        this.employeeAge = employeeAge;
        this.entryTime = entryTime;
        this.staff = staff;
        this.employeeMessage = employeeMessage;
    }

    /**
     * 获取员工账号。
     * @return 员工账号。
     */
    public Integer getEmployeeAccount() {
        return employeeAccount;
    }

    /**
     * 设置员工账号。
     * @param employeeAccount 员工账号。
     */
    public void setEmployeeAccount(Integer employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    /**
     * 获取员工姓名。
     * @return 员工姓名。
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * 设置员工姓名。
     * @param employeeName 员工姓名。
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * 获取员工性别。
     * @return 员工性别。
     */
    public String getEmployeeGender() {
        return employeeGender;
    }

    /**
     * 设置员工性别。
     * @param employeeGender 员工性别。
     */
    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    /**
     * 获取员工年龄。
     * @return 员工年龄。
     */
    public Integer getEmployeeAge() {
        return employeeAge;
    }

    /**
     * 设置员工年龄。
     * @param employeeAge 员工年龄。
     */
    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    /**
     * 获取入职时间。
     * @return 入职时间。
     */
    public String getEntryTime() {
        return entryTime;
    }

    /**
     * 设置入职时间。
     * @param entryTime 入职时间。
     */
    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    /**
     * 获取职位。
     * @return 职位。
     */
    public String getStaff() {
        return staff;
    }

    /**
     * 设置职位。
     * @param staff 职位。
     */
    public void setStaff(String staff) {
        this.staff = staff;
    }

    /**
     * 获取员工备注信息。
     * @return 员工备注信息。
     */
    public String getEmployeeMessage() {
        return employeeMessage;
    }

    /**
     * 设置员工备注信息。
     * @param employeeMessage 员工备注信息。
     */
    public void setEmployeeMessage(String employeeMessage) {
        this.employeeMessage = employeeMessage;
    }

    /**
     * 返回Employee对象的字符串表示形式。
     * @return 包含员工详细信息的字符串。
     */
    @Override
    public String toString() {
        return "Employee{" +
                "employeeAccount=" + employeeAccount +
                ", employeeName='" + employeeName + '\'' +
                ", employeeGender='" + employeeGender + '\'' +
                ", employeeAge=" + employeeAge +
                ", entryTime='" + entryTime + '\'' +
                ", staff='" + staff + '\'' +
                ", employeeMessage='" + employeeMessage + '\'' +
                '}';
    }
}