package cn.edu.svtcc.service.impl;

import cn.edu.svtcc.dao.administratorDao;
import cn.edu.svtcc.pojo.administrator;
import cn.edu.svtcc.service.administratorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("administratorService")
@Transactional(rollbackFor = Exception.class)
public class administratorServiceImpl implements administratorService {
    private administratorDao dao;

    public administrator login(administrator administrator) {
        return dao.login(administrator);
    }

    public administrator register(administrator administrator) {
        return dao.register(administrator);
    }
}
