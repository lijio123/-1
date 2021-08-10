package com.lijio.dao;

import java.util.List;

import com.lijio.domain.Employee;
import com.lijio.domain.EmployeeClockingArrange;

/**
 * 学生排班安排表DAO接口
 */
public interface EmployeeClockingArrangeDao {
    public void insertWorkTimeArrange(List<Employee> list,int clockingId);
    public void insert(EmployeeClockingArrange clockingArrange);
    public void update(EmployeeClockingArrange clockingArrange);
    public void delete(EmployeeClockingArrange clockingArrange);
    
    public EmployeeClockingArrange queryById(int id);
    
    public List<EmployeeClockingArrange> queryByEmployeeId(int employeeId);
    
    public List<EmployeeClockingArrange> queryAllWorkArrange();
}
