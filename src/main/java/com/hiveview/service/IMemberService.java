package com.hiveview.service;

import com.hiveview.model.Member;

/**
 * Created by IntelliJ IDEA.
 * User: xiaomeng
 * Date: 2019-04-25
 * Time: 18:09
 */

public interface IMemberService {
    Integer saveMember(Member member);

    Member getMemberByMobile(String mobile);

    Member getMemberInfo(Member member);

    Integer updateMember(Member member);
}
