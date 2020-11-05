package cn.edu.svtcc.service.impl;

import cn.edu.svtcc.dao.EmployeeDao;
import cn.edu.svtcc.dao.employeeSalaryDao;
import cn.edu.svtcc.pojo.employeeSalary;
import cn.edu.svtcc.service.employeeSalaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("employeeSalaryService")
@Transactional(rollbackFor = Exception.class)
public class employeeSalaryServiceImpl implements employeeSalaryService {
    private employeeSalaryDao dao;

    public void setDao(employeeSalaryDao dao) {
        this.dao = dao;
    }
    public employeeSalary findEmployeeSalary(long epyid) {
        return ;
    }

    public employeeSalary insertEmployeeSalary(employeeSalary employeeSalary) {
        return null;
    }

    public employeeSalary changeEmployeeSalary(employeeSalary employeeSalary) {
        return null;
    }

    public employeeSalary totalEmployeeSalary(employeeSalary employeeSalary) {
        return null;
    }
}
