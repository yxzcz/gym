package com.milotnt.service;

import com.milotnt.pojo.Member;
import java.util.List;

/**
 * 服务接口，定义会员相关的业务操作。
 */
public interface MemberService {

    /**
     * 查询所有会员信息。
     * @return 返回包含所有会员信息的列表。
     */
    List<Member> findAll();

    /**
     * 新增会员信息。
     * @param member 会员对象。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    Boolean insertMember(Member member);

    /**
     * 根据会员账号修改会员信息。
     * @param member 会员对象。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    Boolean updateMemberByMemberAccount(Member member);

    /**
     * 用户登录，根据账号和密码查询会员信息。
     * @param member 包含账号和密码的会员对象。
     * @return 如果找到匹配的会员，则返回会员对象，否则返回null。
     */
    Member userLogin(Member member);

    /**
     * 根据会员账号删除会员信息。
     * @param memberAccount 会员账号。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    Boolean deleteByMemberAccount(Integer memberAccount);

    /**
     * 查询会员总数。
     * @return 返回会员总数。
     */
    Integer selectTotalCount();

    /**
     * 根据会员账号查询会员。
     * @param memberAccount 会员账号。
     * @return 返回包含特定会员信息的列表。
     */
    List<Member> selectByMemberAccount(Integer memberAccount);

}