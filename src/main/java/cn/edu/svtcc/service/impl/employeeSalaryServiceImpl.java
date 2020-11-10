package cn.edu.svtcc.service.impl;

import cn.edu.svtcc.dao.employeeSalaryDao;
import cn.edu.svtcc.pojo.employeeSalary;
import cn.edu.svtcc.service.employeeSalaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("employeeSalaryService")
@Transactional(rollbackFor = Exception.class)
public class employeeSalaryServiceImpl implements employeeSalaryService {
    private employeeSalaryDao dao;

    public void setDao(employeeSalaryDao dao) {
        this.dao = dao;
    }
    public employeeSalary findEmployeeSalary(long epyid) {
        return dao.findEmployeeSalary(epyid);
    }

    public int insertEmployeeSalary(employeeSalary employeeSalary) {
        return dao.insertEmployeeSalary(employeeSalary);
    }

    public int changeEmployeeSalary(employeeSalary employeeSalary) {
        return dao.changeEmployeeSalary(employeeSalary);
    }

    public List<employeeSalary> totalEmployeeSalary() {
        return dao.totalEmployeeSalary();
    }
}
