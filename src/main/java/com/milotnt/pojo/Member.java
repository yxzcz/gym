package com.milotnt.pojo;

import cn.hutool.crypto.digest.DigestUtil;
import java.util.Objects;

/**
 * 实体类，代表一个会员的基本信息。
 */
public class Member {

    /**
     * 会员账号。
     */
    private Integer memberAccount;

    /**
     * 会员密码。
     */
    private String memberPassword;

    /**
     * 会员姓名。
     */
    private String memberName;

    /**
     * 会员性别。
     */
    private String memberGender;

    /**
     * 会员年龄。
     */
    private Integer memberAge;

    /**
     * 会员身高。
     */
    private Integer memberHeight;

    /**
     * 会员体重。
     */
    private Integer memberWeight;

    /**
     * 会员电话。
     */
    private Long memberPhone;

    /**
     * 会员卡有效期。
     */
    private String cardTime;

    /**
     * 会员卡已上课次数。
     */
    private Integer cardClass;

    /**
     * 会员卡剩余课次数。
     */
    private Integer cardNextClass;

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
     * 获取会员密码。
     * @return 会员密码。
     */
    public String getMemberPassword() {
        return memberPassword;
    }

    /**
     * 设置会员密码。
     * @param memberPassword 会员密码。
     */
    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    /**
     * 获取会员姓名。
     * @return 会员姓名。
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 设置会员姓名。
     * @param memberName 会员姓名。
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * 获取会员性别。
     * @return 会员性别。
     */
    public String getMemberGender() {
        return memberGender;
    }

    /**
     * 设置会员性别。
     * @param memberGender 会员性别。
     */
    public void setMemberGender(String memberGender) {
        this.memberGender = memberGender;
    }

    /**
     * 获取会员年龄。
     * @return 会员年龄。
     */
    public Integer getMemberAge() {
        return memberAge;
    }

    /**
     * 设置会员年龄。
     * @param memberAge 会员年龄。
     */
    public void setMemberAge(Integer memberAge) {
        this.memberAge = memberAge;
    }

    /**
     * 获取会员身高。
     * @return 会员身高。
     */
    public Integer getMemberHeight() {
        return memberHeight;
    }

    /**
     * 设置会员身高。
     * @param memberHeight 会员身高。
     */
    public void setMemberHeight(Integer memberHeight) {
        this.memberHeight = memberHeight;
    }

    /**
     * 获取会员体重。
     * @return 会员体重。
     */
    public Integer getMemberWeight() {
        return memberWeight;
    }

    /**
     * 设置会员体重。
     * @param memberWeight 会员体重。
     */
    public void setMemberWeight(Integer memberWeight) {
        this.memberWeight = memberWeight;
    }

    /**
     * 获取会员电话。
     * @return 会员电话。
     */
    public Long getMemberPhone() {
        return memberPhone;
    }

    /**
     * 设置会员电话。
     * @param memberPhone 会员电话。
     */
    public void setMemberPhone(Long memberPhone) {
        this.memberPhone = memberPhone;
    }

    /**
     * 获取会员卡有效期。
     * @return 会员卡有效期。
     */
    public String getCardTime() {
        return cardTime;
    }

    /**
     * 设置会员卡有效期。
     * @param cardTime 会员卡有效期。
     */
    public void setCardTime(String cardTime) {
        this.cardTime = cardTime;
    }

    /**
     * 获取会员卡已上课次数。
     * @return 会员卡已上课次数。
     */
    public Integer getCardClass() {
        return cardClass;
    }

    /**
     * 设置会员卡已上课次数。
     * @param cardClass 会员卡已上课次数。
     */
    public void setCardClass(Integer cardClass) {
        this.cardClass = cardClass;
    }

    /**
     * 获取会员卡剩余课次数。
     * @return 会员卡剩余课次数。
     */
    public Integer getCardNextClass() {
        return cardNextClass;
    }

    /**
     * 设置会员卡剩余课次数。
     * @param cardNextClass 会员卡剩余课次数。
     */
    public void setCardNextClass(Integer cardNextClass) {
        this.cardNextClass = cardNextClass;
    }

    /**
     * 加密会员密码。
     * @param password 会员密码。
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
        return Objects.equals(encryptedPassword, this.memberPassword);
    }

    /**
     * 返回Member对象的字符串表示形式。
     * @return 包含会员详细信息的字符串。
     */
    @Override
    public String toString() {
        return "Member{" +
                "memberAccount=" + memberAccount +
                ", memberPassword='" + memberPassword + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberGender='" + memberGender + '\'' +
                ", memberAge=" + memberAge +
                ", memberHeight=" + memberHeight +
                ", memberWeight=" + memberWeight +
                ", memberPhone=" + memberPhone +
                ", cardTime='" + cardTime + '\'' +
                ", cardClass=" + cardClass +
                ", cardNextClass=" + cardNextClass +
                '}';
    }
}