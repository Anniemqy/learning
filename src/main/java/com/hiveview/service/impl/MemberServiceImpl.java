package com.hiveview.service.impl;

import com.hiveview.dao.IMemberDao;
import com.hiveview.model.Member;
import com.hiveview.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: xiaomeng
 * Date: 2019-04-25
 * Time: 18:09
 */

@Service
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private IMemberDao memberDao;

    @Override
    public Integer saveMember(Member member) {
        member.setType(-1);
        return memberDao.insertSelective(member);
    }

    @Override
    public Integer updateMember(Member member) {
        return memberDao.updateByPrimaryKeySelective(member);
    }
}
