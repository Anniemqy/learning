package com.hiveview.service.impl;

import com.hiveview.dao.IMemberDao;
import com.hiveview.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huxunqiang created on 2019/4/16
 */
@Service
public class IRegisterServiceImpl implements IRegisterService {
    @Autowired
    private IMemberDao memberDao;

    public boolean checkPhoneRegister(String phone){
        int count = 0;
        try {
            count = memberDao.verifyPhoneRegister(phone);
        }catch (Exception e){

        }
        return count==0 ? false : true;
    }
}
