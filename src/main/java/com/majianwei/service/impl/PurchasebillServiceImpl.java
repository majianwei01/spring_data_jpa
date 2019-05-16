package com.majianwei.service.impl;

import com.majianwei.common.UserContext;
import com.majianwei.domain.Employee;
import com.majianwei.domain.Purchasebill;
import com.majianwei.repository.PurchasebillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.IPurchasebillService;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PurchasebillServiceImpl extends BaseServiceImpl<Purchasebill,Long> implements IPurchasebillService {
    @Autowired
    private PurchasebillRepository purchasebillRepository;

    //这一步是解决单据添加功能里录入人不能为空的问题
    //当前登录人其实就是录入人，所以将录入人设置为当前登录用户
    @Transactional
    public void save(Purchasebill bill){
        //System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu"+UserContext.getUser());
            bill.setInputUser(UserContext.getUser());

        purchasebillRepository.save(bill);
    }

}