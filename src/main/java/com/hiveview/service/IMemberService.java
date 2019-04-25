package com.hiveview.service;

import com.hiveview.model.Member;

public interface IMemberService {
    Integer saveMember(Member member);

    Integer updateMember(Member member);
}
