package com.hiveview.dao;

import com.hiveview.model.Member;
import org.springframework.stereotype.Repository;

/**
 * @author huxunqiang created on 2019/4/16
 */
@Repository
public interface IMemberDao {

    int insertSelective(Member member); //todo 和传Member record有什么区别，record是Member的一个别名吗？

    int verifyPhoneRegister(String phone);

    int updateByPrimaryKeySelective(Member member);
}
