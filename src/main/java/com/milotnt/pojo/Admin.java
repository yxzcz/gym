package com.milotnt.pojo;

import cn.hutool.crypto.digest.DigestUtil;
import java.util.Objects;

/**
 * 实体类，代表一个管理员账户。
 */
public class Admin {

    /**
     * 管理员账号。
     */
    private Integer adminAccount;

    /**
     * 管理员密码。
     */
    private String adminPassword;

    /**
     * 获取管理员账号。
     * @return 管理员账号。
     */
    public Integer getAdminAccount() {
        return adminAccount;
    }

    /**
     * 设置管理员账号。
     * @param adminAccount 管理员账号。
     */
    public void setAdminAccount(Integer adminAccount) {
        this.adminAccount = adminAccount;
    }

    /**
     * 获取管理员密码。
     * @return 管理员密码。
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * 设置管理员密码。
     * @param adminPassword 管理员密码。
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    /**
     * 加密管理员密码。
     * @param password 管理员密码。
     * @return 加密后的密码。
     */
    public String encryptPassword(String password) {
        return DigestUtil.md5Hex(password);
    }

    /**
     * 验证密码是否匹配。
     * @param inputPassword 输入的密码。
     * @return 如果密码匹配返回true，否则返回false。
     */
    public boolean verifyPassword(String inputPassword) {
        String encryptedPassword = encryptPassword(inputPassword);
        return Objects.equals(encryptedPassword, this.adminPassword);
    }

    /**
     * 返回Admin对象的字符串表示形式。
     * @return 包含管理员账号和密码的字符串。
     */
    @Override
    public String toString() {
        return "Admin{" +
                "adminAccount=" + adminAccount +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}