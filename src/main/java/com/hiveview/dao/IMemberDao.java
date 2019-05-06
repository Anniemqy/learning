package com.hiveview.dao;

import com.hiveview.model.Member;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: xiaomeng
 * Date: 2019-04-25
 * Time: 18:09
 */

@Repository
public interface IMemberDao {

    int insertSelective(Member member);

    int verifyPhoneRegister(String phone);

    Member get(Member member);

    int updateByPrimaryKeySelective(Member member);
}
