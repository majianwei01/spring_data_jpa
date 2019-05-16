package  com.majianwei.service.impl;

import com.majianwei.domain.Dept;
import com.majianwei.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.IDeptService;


@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept,Long> implements IDeptService {
    @Autowired
    private DeptRepository deptRepository;

}