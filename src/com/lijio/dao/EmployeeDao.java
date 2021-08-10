package com.lijio.dao;

import java.util.List;

import com.lijio.annotation.Immutable;
import com.lijio.domain.Employee;

/**
 * 员工DAO接口
 */
@Immutable
public interface EmployeeDao {
    public void insert(Employee employee)throws Exception;
    public void update(Employee employee);
    public void delete(Employee employee);
    
    public Employee queryById(int employeeId);
    public Employee queryByNoId(Employee employee);
    public List<Employee> queryAll(); 
}
